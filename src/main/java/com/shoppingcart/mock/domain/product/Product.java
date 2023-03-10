package com.shoppingcart.mock.domain.product;

import java.math.BigDecimal;
import java.util.Objects;

public sealed class Product permits CountableProduct, UnCountableProduct {
  private String productName;
  private BigDecimal price;
  private String barcode;
  private ProductType productType;
  private boolean ageRestricted;

   public Product(String productName, BigDecimal price, String barcode, ProductType productType, boolean ageRestricted) {
      this.productName = productName;
      this.price = price;
      this.barcode = barcode;
      this.productType = productType;
      this.ageRestricted = ageRestricted;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public String getBarcode() {
      return barcode;
   }

   public void setBarcode(String barcode) {
      this.barcode = barcode;
   }

   public ProductType getProductType() {
      return productType;
   }

   public void setProductType(ProductType productType) {
      this.productType = productType;
   }

    public boolean isAgeRestricted() {
        return ageRestricted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) && Objects.equals(barcode, product.barcode) && productType == product.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, barcode, productType);
    }
}
