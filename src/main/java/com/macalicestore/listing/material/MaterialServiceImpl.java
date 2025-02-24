package com.macalicestore.listing.material;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Transactional
    @Override
    public List<Material> findMaterialsByNames(List<String> names) {
//        List<Material> existingMaterials = materialRepository.findMaterialsByNameIn(names);
//        Map<String, Material> nameMaterialMap = existingMaterials.stream()
//                .collect(Collectors.toMap(Material::getName, material -> material, (a, b) -> b));
//        names.forEach(e -> Objects.requireNonNullElse(nameMaterialMap.get(e.getName()), materialRepository.save(e)));
//        return names;
        return null;
    }
}
