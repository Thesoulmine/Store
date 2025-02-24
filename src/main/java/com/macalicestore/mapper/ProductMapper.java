package com.macalicestore.mapper;

import com.macalicestore.dto.ProductDTO;
import com.macalicestore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);
}


