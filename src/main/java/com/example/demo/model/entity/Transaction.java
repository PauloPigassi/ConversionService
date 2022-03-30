package com.example.demo.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.catalina.User;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @ManyToOne
    @JoinColumn(name="user_code")
    private UserTransaction userCode;

    @Column(nullable = false)
    private CurrencyEnum baseCurrency;

    @Column(nullable = false)
    private BigDecimal baseValue;

    @Column(nullable = false)
    private CurrencyEnum destinationCurrency;

    @Column(nullable = false)
    private BigDecimal conversionTax;

    @Column(nullable = false)
    private LocalDateTime date;

    public Transaction() {
    }

	
	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public UserTransaction getUserCode() {
		return userCode;
	}


	public void setUserCode(UserTransaction userCode) {
		this.userCode = userCode;
	}


	public CurrencyEnum getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(CurrencyEnum baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public BigDecimal getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(BigDecimal baseValue) {
        this.baseValue = baseValue;
    }

    public CurrencyEnum getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(CurrencyEnum destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public BigDecimal getConversionTax() {
        return conversionTax;
    }

    public void setConversionTax(BigDecimal conversionTax) {
        this.conversionTax = conversionTax;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + code +
                ", user=" + userCode +
                ", baseCurrency=" + baseCurrency +
                ", baseValue=" + baseValue +
                ", destinationCurrency=" + destinationCurrency +
                ", conversionTax=" + conversionTax +
                ", date=" + date +
                '}';
    }
}
