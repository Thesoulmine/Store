package com.macalicestore.listing.price;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Currency;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "currency", source = "currencyCode")
    Price toEntity(PriceDTO priceDTO);

    @Mapping(target = "currencyCode", source = "currency")
    PriceDTO toDto(Price price);

    default Currency mapCurrencyCode(String currencyCode) {
        if (currencyCode == null || currencyCode.isEmpty()) {
            return null;
        }
        return Currency.getInstance(currencyCode);
    }

    default String mapCurrency(Currency currency) {
        if (currency == null) {
            return null;
        }
        return currency.getCurrencyCode();
    }
}