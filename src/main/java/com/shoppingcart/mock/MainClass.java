package com.shoppingcart.mock;

import com.shoppingcart.mock.domain.offer.NoOffer;
import com.shoppingcart.mock.domain.policies.NoPolicy;
import com.shoppingcart.mock.domain.policies.SeasonalSalePolicy;
import com.shoppingcart.mock.domain.product.CountableProduct;
import com.shoppingcart.mock.domain.product.UnCountableProduct;
import com.shoppingcart.mock.domain.user.User;
import com.shoppingcart.mock.service.CheckoutService;

import java.math.BigDecimal;

import static com.shoppingcart.mock.domain.product.ProductType.COUNTABLE;
import static com.shoppingcart.mock.domain.product.ProductType.UNCOUNTABLE;

public class MainClass {

    // structure
    public static void main(String[] args) {

        CheckoutService cartService = new CheckoutService(
                new User("aqib", "aqib123", 29, false),
                new NoOffer());




        // Creating Product and will add to cartItem
        // ASDA-MILK------------------
        cartService.addProductItem(new UnCountableProduct(
                "ASDA-MILK",
                BigDecimal.TEN,
                "milk123",
                UNCOUNTABLE,
                false,
                BigDecimal.valueOf(2.8)),
                new SeasonalSalePolicy(BigDecimal.TEN));

        cartService.addProductItem(new UnCountableProduct(
                "ASDA-MILK",
                BigDecimal.TEN,
                "milk123",
                UNCOUNTABLE,
                false,
                BigDecimal.valueOf(2.8)),
                new SeasonalSalePolicy(BigDecimal.TEN));

        // ASDA-AppleJuice------------------
        cartService.addProductItem(new UnCountableProduct(
                "ASDA-AppleJuice",
                BigDecimal.TEN,
                "juice123",
                UNCOUNTABLE,
                false,
                BigDecimal.valueOf(2.8)),
                new NoPolicy());
        // Alcohol 18+
        cartService.addProductItem(new CountableProduct(
                "Vine",
                BigDecimal.TEN,
                "vine123",
                COUNTABLE,
                true,
                1),
                new NoPolicy());

        System.out.println(cartService.checkOut());

    }
}
