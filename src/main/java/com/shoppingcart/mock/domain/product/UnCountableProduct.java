package com.shoppingcart.mock.domain.product;

import java.math.BigDecimal;

public non-sealed class UnCountableProduct extends Product {
    private BigDecimal weight;

    public UnCountableProduct(String productName, BigDecimal price, String barcode, ProductType productType, boolean ageRestricted, BigDecimal weight) {
        super(productName, price, barcode, productType, ageRestricted);
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
