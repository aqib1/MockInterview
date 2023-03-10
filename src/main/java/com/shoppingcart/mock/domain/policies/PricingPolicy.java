package com.shoppingcart.mock.domain.policies;

import com.shoppingcart.mock.domain.product.Product;

public sealed interface PricingPolicy permits NoPolicy, SeasonalSalePolicy {
    void apply(Product product);
}
