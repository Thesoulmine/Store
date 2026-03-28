package com.macalicestore.listing.listing;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ListingService extends CommonListingService {

    private final Map<Class<? extends SaveListingDTO>, ConcreteListingService<? extends Listing, ? extends ListingDTO, ? extends SaveListingDTO>> listingServiceByListingClassMap;

    public ListingService(List<ConcreteListingService<? extends Listing, ? extends ListingDTO, ? extends SaveListingDTO>> concreteListingServiceList) {
        this.listingServiceByListingClassMap = new HashMap<>();
        concreteListingServiceList.forEach(concreteListingService ->
                listingServiceByListingClassMap.put(
                        concreteListingService.getSaveDTOClass(),
                        concreteListingService));
    }

    @Transactional
    @Override
    public Page<Listing> findAll(Pageable pageable) {
        return listingRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Page<Listing> findAll(Set<Class<? extends Listing>> listingClasses, Pageable pageable) {
        if (listingClasses == null) {
            return listingRepository.findAll(pageable);
        }
        listingClasses.remove(Listing.class);
        if (listingClasses.isEmpty()) {
            return listingRepository.findAll(pageable);
        }
        Specification<Listing> specification =
                (root, _, _) -> root.get("listingType").in(listingClasses);
        return listingRepository.findAll(specification, pageable);
    }

    @Transactional
    @Override
    public Listing findById(Long id) {
        return listingRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Listing create(SaveListingDTO saveListingDTO) {
        return getConcreteListingService(saveListingDTO).create(saveListingDTO);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        listingRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Listing update(SaveListingDTO saveListingDTO) {
        return getConcreteListingService(saveListingDTO).update(saveListingDTO);
    }

    private <S extends SaveListingDTO> ConcreteListingService<?, ?, S> getConcreteListingService(SaveListingDTO saveListingDTO) {
        return (ConcreteListingService<?, ?, S>) listingServiceByListingClassMap.get(saveListingDTO.getClass());
    }
}
