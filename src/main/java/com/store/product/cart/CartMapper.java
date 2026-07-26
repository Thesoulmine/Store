package com.store.product.cart;

import com.store.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends BaseMapper<Cart, CartDTO> {
}
