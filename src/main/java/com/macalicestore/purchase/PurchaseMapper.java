package com.macalicestore.purchase;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseDTO toDTO(Purchase purchase);

    Purchase toEntity(PurchaseDTO purchaseDTO);
}


