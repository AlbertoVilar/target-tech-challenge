package com.target.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class Sale {

    @JsonProperty("vendedor")
    private String sellerName;

    @JsonProperty("valor")
    private BigDecimal value;

    private BigDecimal sellerCommission;

    public Sale() {}


    public Sale(String sellerName, BigDecimal value, BigDecimal sellerCommission) {
        this.sellerName = sellerName;
        this.value = value;
        this.sellerCommission = sellerCommission;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getSellerCommission() {
        return sellerCommission;
    }

    public void setSellerCommission(BigDecimal sellerCommission) {
        this.sellerCommission = sellerCommission;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(sellerName, sale.sellerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sellerName);
    }
}
