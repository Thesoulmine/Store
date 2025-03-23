package com.macalicestore.listing.listingsgroup;

import java.util.List;

public interface ListingsGroupService {

    List<ListingsGroup> getAllListingsGroups();

    ListingsGroup getListingsGroupById(Long id);

    void saveListingsGroup(ListingsGroupDTO listingsGroupDTO);
}
