package com.macalicestore.listing.listingsgroup;

import java.util.List;

public interface ListingsGroupService {

    List<ListingsGroup> getAllListingsGroups();

    ListingsGroup getListingsGroupById(Long id);

    ListingsGroup saveListingsGroup(ListingsGroup listingsGroup);

    void deleteListingsGroupById(Long id);

    ListingsGroup updateListingsGroup(ListingsGroup listingsGroup, Long id);
}
