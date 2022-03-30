package com.example.demo.model.factory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.CurrencyEnum;
import com.example.demo.model.entity.Transaction;
import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.TransactionTO;

@SpringBootTest
public class TransactionTOFactoryTest {

    @Test
    public void create(){

        Transaction transaction = new Transaction();
        transaction.setUserCode(new UserTransaction());
        transaction.getUserCode().setUserCode(1L);
        transaction.setBaseValue(BigDecimal.valueOf(2));
        transaction.setBaseCurrency(CurrencyEnum.BRL);
        transaction.setDestinationCurrency(CurrencyEnum.USD);
        transaction.setConversionTax(BigDecimal.valueOf(0.5));
        transaction.setDate(LocalDateTime.now());
        TransactionTO transactionTO = TransactionTOFactory.create(transaction);

        Assertions.assertThat(transactionTO.getDestinationValue()).isEqualTo(BigDecimal.valueOf(1).setScale(2));
    }

}
