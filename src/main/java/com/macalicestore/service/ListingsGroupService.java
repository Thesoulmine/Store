package com.macalicestore.service;

import com.macalicestore.dto.ListingsGroupDTO;
import com.macalicestore.entity.ListingsGroup;

import java.util.List;

public interface ListingsGroupService {

    List<ListingsGroup> getAllListingsGroups();

    ListingsGroup getListingsGroupById(Long id);

    void saveListingsGroup(ListingsGroupDTO listingsGroupDTO);
}
