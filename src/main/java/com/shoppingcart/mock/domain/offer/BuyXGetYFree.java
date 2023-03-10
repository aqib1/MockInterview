package com.shoppingcart.mock.domain.offer;

import com.shoppingcart.mock.domain.cart.CartItem;
import java.util.concurrent.ConcurrentMap;

public record BuyXGetYFree(int buyX, int freeY) implements Offer {
    public BuyXGetYFree {
        if(freeY > buyX)  throw new IllegalArgumentException();
    }

    @Override
    public void apply(ConcurrentMap<CartItem, Integer> cartItems) {
        cartItems.forEach(((cartItem, count) -> {
                if(count >= buyX)
                    cartItems.put(cartItem, count - freeY);
            }));
    }
}
