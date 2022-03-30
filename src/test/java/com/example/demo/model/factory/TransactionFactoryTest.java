package com.example.demo.model.factory;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Transaction;
import com.example.demo.model.to.ExchangeRatesTO;
import com.example.demo.model.to.Rates;
import com.example.demo.model.to.TransactionRequestTO;

@SpringBootTest
public class TransactionFactoryTest {

    @Test
    public void createTest(){

        TransactionRequestTO transactionRequestTO = new TransactionRequestTO();
        transactionRequestTO.setUserId(3L);
        transactionRequestTO.setBaseCurrency("JPY");
        transactionRequestTO.setBaseValue(BigDecimal.valueOf(1));
        transactionRequestTO.setDestinationCurrency("EUR");

        ExchangeRatesTO exchangeRatesTO = new ExchangeRatesTO();
        Rates rates = new Rates();
        rates.setEur(BigDecimal.valueOf(0.8345155637));
        exchangeRatesTO.setBase("JPY");
        exchangeRatesTO.setDate("2021-02-05");
        exchangeRatesTO.setRates(rates);

        Transaction transaction = TransactionFactory.create(transactionRequestTO, exchangeRatesTO);

        Assertions.assertThat(transaction.getConversionTax()).isEqualTo(rates.getEur().toString());
        Assertions.assertThat(transaction.getBaseValue()).isEqualTo(BigDecimal.ONE);
    }
}
