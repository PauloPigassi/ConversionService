package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.to.ExchangeRatesTO;

@SpringBootTest
public class ExchangeRatesServiceTest {

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @Test
    public void getExchangeRatesTOTest(){
        ExchangeRatesTO exchangeRatesTO = exchangeRatesService.getExchangeRatesTO("EUR", "USD");
        Assertions.assertThat(exchangeRatesTO).isNotNull();
        Assertions.assertThat(exchangeRatesTO.getRates().getUsd()).isPositive();
    }

}
