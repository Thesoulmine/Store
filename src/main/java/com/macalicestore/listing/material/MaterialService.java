package com.macalicestore.listing.material;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MaterialService {
    @Transactional
    List<Material> findMaterialsByNames(List<String> names);
}
