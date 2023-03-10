package com.shoppingcart.mock.domain.policies;

import com.shoppingcart.mock.domain.product.Product;


public record NoPolicy() implements PricingPolicy {

    @Override
    public void apply(Product product) {

    }
}
