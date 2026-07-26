package com.store.product.product;

import com.store.base.BaseMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDTO> {
}
