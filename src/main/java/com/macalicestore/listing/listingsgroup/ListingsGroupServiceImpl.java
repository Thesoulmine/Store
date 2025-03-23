package com.macalicestore.listing.listingsgroup;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingsGroupServiceImpl implements ListingsGroupService {

    private final ListingsGroupRepository listingsGroupRepository;

    private final ListingsGroupMapper listingsGroupMapper;

    public ListingsGroupServiceImpl(ListingsGroupRepository listingsGroupRepository, ListingsGroupMapper listingsGroupMapper) {
        this.listingsGroupRepository = listingsGroupRepository;
        this.listingsGroupMapper = listingsGroupMapper;
    }

    @Override
    public List<ListingsGroup> getAllListingsGroups() {
        return listingsGroupRepository.findAll();
    }

    @Override
    public ListingsGroup getListingsGroupById(Long id) {
        return listingsGroupRepository.findById(id).get();
    }

    @Override
    public void saveListingsGroup(ListingsGroupDTO listingsGroupDTO) {
        ListingsGroup listingsGroup = listingsGroupMapper.toEntity(listingsGroupDTO);
        listingsGroupRepository.save(listingsGroup);
    }
}
