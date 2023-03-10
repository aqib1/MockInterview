package com.shoppingcart.mock.service;

import com.shoppingcart.mock.domain.cart.CartItem;
import com.shoppingcart.mock.domain.offer.Offer;
import com.shoppingcart.mock.domain.policies.PricingPolicy;
import com.shoppingcart.mock.domain.product.Product;
import com.shoppingcart.mock.domain.receipt.IReceipt;
import com.shoppingcart.mock.domain.user.User;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CheckoutService {
    private final ConcurrentMap<CartItem, Integer> cartItems;
    private final Offer offer;
    private final User user;

    public CheckoutService(User user, Offer offer) {
        this.cartItems = new ConcurrentHashMap<>();
        this.user = user;
        this.offer = offer;
    }

    public void addProductItem(Product product, PricingPolicy policy) {
        if(user.isUnderAge() && product.isAgeRestricted())
            throw new RuntimeException();

        CartItem cartItem = new CartItem(product, policy);
        if(cartItems.containsKey(cartItem)) {
            cartItems.put(cartItem, cartItems.get(cartItem) + 1);
        } else {
            cartItems.put(cartItem, 1);
        }
    }

    public void removeProductItem(Product product) {
        CartItem cartItem = new CartItem(product);
        if(cartItems.containsKey(cartItem)
                && cartItems.get(cartItem) > 0) {
            cartItems.put(cartItem, cartItems.get(cartItem) - 1);
        }
    }

    public void removeAllProducts(Product product) {
        cartItems.remove(new CartItem(product));
    }

    private BigDecimal calculateTotalCost() {
        BigDecimal sum = BigDecimal.ZERO;

        // apply pricing policies and offers
        cartItems.forEach((cartItem, count) -> cartItem.applyPricingPolicy());

        offer.apply(this.cartItems);

        // calculate total cost
        for(CartItem cartItem : cartItems.keySet()) {
                sum = sum.add(cartItem.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(cartItems.get(cartItem))));
        }

        return sum;
    }

    public IReceipt checkOut() {
        return new IReceipt(cartItems, calculateTotalCost());
    }

}
