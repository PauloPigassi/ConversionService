package com.example.demo.service;


import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.to.TransactionRequestTO;
import com.example.demo.model.to.TransactionTO;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class CurrencyConverterServiceTest {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void convert(){
        //Mock
        BDDMockito.when(userRepository.existsById(1L)).thenReturn(true);

        TransactionRequestTO transactionRequestTO = new TransactionRequestTO();
        transactionRequestTO.setUserId(1L);
        transactionRequestTO.setBaseCurrency("BRL");
        transactionRequestTO.setBaseValue(BigDecimal.valueOf(1));
        transactionRequestTO.setDestinationCurrency("USD");

        TransactionTO transactionTO = currencyConverterService.convert(transactionRequestTO);

        Assertions.assertThat(transactionTO).isNotNull();

        transactionRepository.deleteById(transactionTO.getId());
    }

}
