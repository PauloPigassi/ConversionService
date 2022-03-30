package com.example.demo.model.to;

import java.io.Serializable;

public class ExchangeRatesTO implements Serializable {

    private Rates rates;
    private String base;
    private String date;

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeRatesTO{" +
                "rates=" + rates +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
