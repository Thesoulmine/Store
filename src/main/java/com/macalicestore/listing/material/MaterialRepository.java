package com.macalicestore.listing.material;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findMaterialsByNameIn(List<String> names);
}
