package com.shoppingcart.mock.domain.cart;

import com.shoppingcart.mock.domain.policies.NoPolicy;
import com.shoppingcart.mock.domain.policies.PricingPolicy;
import com.shoppingcart.mock.domain.product.Product;

import java.util.Objects;

public record CartItem (Product product, PricingPolicy pricingPolicy) {

    public CartItem(Product product) {
        this(product, new NoPolicy());
    }

    public Product getProduct() {
        return product;
    }

    public void applyPricingPolicy() {
         pricingPolicy.apply(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
