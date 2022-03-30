package com.example.demo.model.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates implements Serializable {

    @JsonProperty("BRL")
    private BigDecimal brl;

    @JsonProperty("USD")
    private BigDecimal usd;

    @JsonProperty("EUR")
    private BigDecimal eur;

    @JsonProperty("JPY")
    private BigDecimal jpy;

    public BigDecimal getBrl() { return brl; }

    public void setBrl(BigDecimal brl) {
        this.brl = brl;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    public BigDecimal getEur() {
        return eur;
    }

    public void setEur(BigDecimal eur) {
        this.eur = eur;
    }

    public BigDecimal getJpy() {
        return jpy;
    }

    public void setJpy(BigDecimal jpy) {
        this.jpy = jpy;
    }
}
