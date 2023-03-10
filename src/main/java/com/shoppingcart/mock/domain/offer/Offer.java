package com.shoppingcart.mock.domain.offer;

import com.shoppingcart.mock.domain.cart.CartItem;

import java.util.concurrent.ConcurrentMap;

public sealed interface Offer permits NoOffer, BuyXGetYFree {
    void apply(ConcurrentMap<CartItem, Integer> cartItems);
}
