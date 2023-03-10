package com.shoppingcart.mock.domain.policies;

import com.shoppingcart.mock.domain.cart.CartItem;
import com.shoppingcart.mock.domain.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record SeasonalSalePolicy(BigDecimal discountPercentage) implements PricingPolicy {

    @Override
    public void apply(Product product) {
        product.setPrice(product.getPrice().subtract(
                discountPercentage.divide(BigDecimal.valueOf(100), 2, RoundingMode.FLOOR)
                        .multiply(product.getPrice())));
    }
}
