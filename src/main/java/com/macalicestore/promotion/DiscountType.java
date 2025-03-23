package com.macalicestore.promotion;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum DiscountType {
    FIXED {
        @Override
        protected BigDecimal applyDiscount(BigDecimal amount, BigDecimal discount) {
            return amount.subtract(discount).setScale(2, RoundingMode.HALF_UP);
        }

        @Override
        protected void checkDiscount(BigDecimal amount, BigDecimal discount) throws IllegalArgumentException {
            if (discount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Discount cannot be negative");
            }
            if (discount.compareTo(amount) > 0) {
                throw new IllegalArgumentException("Discount cannot be greater than the amount");
            }
        }
    },
    PERCENTAGE {
        @Override
        protected BigDecimal applyDiscount(BigDecimal amount, BigDecimal discount) {
            return new BigDecimal("100")
                    .subtract(discount)
                    .multiply(amount)
                    .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        }

        @Override
        protected void checkDiscount(BigDecimal amount, BigDecimal discount) throws IllegalArgumentException {
            if (discount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Discount percentage cannot be negative");
            }
            if (discount.compareTo(BigDecimal.valueOf(100)) > 0) {
                throw new IllegalArgumentException("Discount percentage cannot be greater than 100");
            }
        }
    };

    public BigDecimal calculateDiscount(BigDecimal amount, BigDecimal discount) {
        checkDiscount(amount, discount);
        return applyDiscount(amount, discount);
    }

    protected abstract BigDecimal applyDiscount(BigDecimal amount, BigDecimal discount);

    protected abstract void checkDiscount(BigDecimal amount, BigDecimal discount) throws IllegalArgumentException;
}
