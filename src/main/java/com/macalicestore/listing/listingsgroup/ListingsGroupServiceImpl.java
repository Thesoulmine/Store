package com.macalicestore.listing.listingsgroup;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListingsGroupServiceImpl implements ListingsGroupService {

    private final ListingsGroupRepository listingsGroupRepository;

    public ListingsGroupServiceImpl(ListingsGroupRepository listingsGroupRepository) {
        this.listingsGroupRepository = listingsGroupRepository;
    }

    @Transactional
    @Override
    public List<ListingsGroup> getAllListingsGroups() {
        return listingsGroupRepository.findAll();
    }

    @Transactional
    @Override
    public ListingsGroup getListingsGroupById(Long id) {
        return listingsGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    @Override
    public ListingsGroup saveListingsGroup(ListingsGroup listingsGroup) {
        return listingsGroupRepository.save(listingsGroup);
    }

    @Transactional
    @Override
    public void deleteListingsGroupById(Long id) {
        listingsGroupRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ListingsGroup updateListingsGroup(ListingsGroup listingsGroup, Long id) {
        listingsGroup.setId(id);
        return listingsGroupRepository.save(listingsGroup);
    }
}
