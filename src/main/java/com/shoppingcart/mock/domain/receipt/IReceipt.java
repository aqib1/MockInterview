package com.shoppingcart.mock.domain.receipt;

import com.shoppingcart.mock.domain.cart.CartItem;
import com.shoppingcart.mock.domain.product.CountableProduct;
import com.shoppingcart.mock.domain.product.Product;
import com.shoppingcart.mock.domain.product.UnCountableProduct;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentMap;

public record IReceipt(ConcurrentMap<CartItem, Integer> cartItems, BigDecimal totalCost) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------Thanks for shopping -------------\n");
        cartItems.forEach((value, count) -> {
            Product product = value.getProduct();
                sb.append("Product Name: ").append(product.getProductName()).append("\n");
                sb.append("Total No: ").append(count).append("\n");
                sb.append("Product Price: ")
                        .append(product.getPrice())
                        .append(" x ")
                        .append(count)
                        .append("\n");
                switch (product.getProductType()) {
                    case COUNTABLE -> sb.append("Quantity: ").append(((CountableProduct)product).getQuantity()).append("\n");
                    case UNCOUNTABLE -> sb.append("Weight: ").append(((UnCountableProduct)product).getWeight()).append("\n");
                }
        });
        sb.append("---------------------------------------------\n");
        sb.append("Total Cost : ").append(totalCost);
        return sb.toString();
    }
}
