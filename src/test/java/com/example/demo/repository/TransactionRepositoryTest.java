package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.CurrencyEnum;
import com.example.demo.model.entity.Transaction;
import com.example.demo.model.entity.UserTransaction;

@SpringBootTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void existsTransactionByUserIdTest(){
        UserTransaction user = userRepository.save(new UserTransaction("test"));

        Transaction transaction = new Transaction();
        transaction.setUserCode(user);
        transaction.setBaseValue(BigDecimal.valueOf(1));
        transaction.setBaseCurrency(CurrencyEnum.BRL);
        transaction.setDestinationCurrency(CurrencyEnum.USD);
        transaction.setConversionTax(BigDecimal.valueOf(0.1836531388));
        transaction.setDate(LocalDateTime.now());

        transaction = transactionRepository.save(transaction);

        Assertions.assertThat(transactionRepository.existsTransactionByUserCode(user.getUserCode())).isTrue();
        Assertions.assertThat(transactionRepository.existsTransactionByUserCode(999L)).isFalse();

        transactionRepository.delete(transaction);
        userRepository.delete(user);

    }

    @Test
    public void findAllByUserIdTest(){
        UserTransaction user = userRepository.save(new UserTransaction("test"));

        Transaction transaction2 = new Transaction();
        transaction2.setUserCode(user);
        transaction2.setBaseValue(BigDecimal.valueOf(1));
        transaction2.setBaseCurrency(CurrencyEnum.BRL);
        transaction2.setDestinationCurrency(CurrencyEnum.USD);
        transaction2.setConversionTax(BigDecimal.valueOf(0.1836531388));
        transaction2.setDate(LocalDateTime.now());

        transaction2 = transactionRepository.save(transaction2);

        Assertions.assertThat(transactionRepository.findAllByUserCode(user.getUserCode()).size()).isEqualTo(1);

        transactionRepository.delete(transaction2);
        userRepository.delete(user);
    }
}
