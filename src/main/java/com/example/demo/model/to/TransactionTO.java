package com.example.demo.model.to;

import java.math.BigDecimal;

public class TransactionTO {

    private Long id;
    private Long userId;
    private String baseCurrency;
    private BigDecimal baseValue;
    private String destinationCurrency;
    private BigDecimal destinationValue;
    private BigDecimal conversionTax;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public BigDecimal getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(BigDecimal baseValue) {
        this.baseValue = baseValue;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public BigDecimal getDestinationValue() {
        return destinationValue;
    }

    public void setDestinationValue(BigDecimal destinationValue) {
        this.destinationValue = destinationValue;
    }

    public BigDecimal getConversionTax() {
        return conversionTax;
    }

    public void setConversionTax(BigDecimal conversionTax) {
        this.conversionTax = conversionTax;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", baseValue=" + baseValue +
                ", destinationCurrency='" + destinationCurrency + '\'' +
                ", destinationValue=" + destinationValue +
                ", conversionTax=" + conversionTax +
                ", date='" + date + '\'' +
                '}';
    }
}
