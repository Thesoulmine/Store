package com.store.promotion;


import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

//    public BigDecimal getBiggestDiscount(Listing listing, List<Discount> discounts) {
//        return discounts.stream()
//                .map(discount ->
//                        discount.getDiscountType().calculateDiscount(listing.getPrice(), discount.getValue()))
//                .min(BigDecimal::compareTo)
//                .orElse(listing.getPrice());
//    }
}
