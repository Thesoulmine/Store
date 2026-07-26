package com.store.product.cart.item;

import com.store.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartItemMapper extends BaseMapper<CartItem, CartItemDTO> {
}
