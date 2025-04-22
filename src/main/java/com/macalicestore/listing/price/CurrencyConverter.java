package com.macalicestore.listing.price;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, String> {

    @Override
    public String convertToDatabaseColumn(Currency currency) {
        if (currency == null) {
            return null;
        }
        return currency.getCurrencyCode();
    }

    @Override
    public Currency convertToEntityAttribute(String currencyCode) {
        if (currencyCode == null || currencyCode.isEmpty()) {
            return null;
        }
        return Currency.getInstance(currencyCode);
    }
}
