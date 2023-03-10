package com.shoppingcart.mock.domain.product;


import java.math.BigDecimal;

public non-sealed class CountableProduct extends Product {
    private long quantity;


    public CountableProduct(String productName, BigDecimal price, String barcode, ProductType productType, boolean ageRestricted, long quantity) {
        super(productName, price, barcode, productType, ageRestricted);
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
