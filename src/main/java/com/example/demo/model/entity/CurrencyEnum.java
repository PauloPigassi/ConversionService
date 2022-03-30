package com.example.demo.model.entity;

import java.util.Arrays;

public enum CurrencyEnum {
    BRL("BRL"), USD("USD"), EUR("EUR"), JPY("JPY");

    private final String text;

    CurrencyEnum(String text) {
        this.text = text;
    }

    public static  CurrencyEnum getCurrencyEnumByText(String currencyText){
        return Arrays.stream(CurrencyEnum.values())
                .filter( currency -> currency.getText().equals(currencyText))
                .findFirst()
                .orElse(null);
    }

    public String getText() {
        return text;
    }
}
