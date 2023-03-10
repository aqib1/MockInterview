package com.shoppingcart.mock.domain.offer;

import com.shoppingcart.mock.domain.cart.CartItem;

import java.util.concurrent.ConcurrentMap;

public record NoOffer() implements Offer {
    @Override
    public void apply(ConcurrentMap<CartItem, Integer> cartItems) {

    }
}
