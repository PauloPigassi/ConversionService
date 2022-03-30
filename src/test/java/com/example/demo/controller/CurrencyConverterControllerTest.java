package com.example.demo.controller;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.error.BadRequestDetails;
import com.example.demo.model.entity.CurrencyEnum;
import com.example.demo.model.entity.Transaction;
import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.TransactionRequestTO;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CurrencyConverterControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    public TransactionRepository transactionRepository;

    @MockBean
    public UserRepository userRepository;

    public Transaction transaction = new Transaction();

    public CurrencyConverterControllerTest(){

        transaction.setUserCode(new UserTransaction());
        transaction.getUserCode().setUserCode(1L);
        transaction.setBaseValue(BigDecimal.valueOf(1));
        transaction.setBaseCurrency(CurrencyEnum.BRL);
        transaction.setDestinationCurrency(CurrencyEnum.USD);
        transaction.setConversionTax(BigDecimal.valueOf(0.1836531388));
        transaction.setDate(LocalDateTime.now());
    }

    @Test
    public void postConvertTestShouldReturnStatusCode200(){
        //Mock
        BDDMockito.when(userRepository.existsById(1L)).thenReturn(true);
        BDDMockito.when(transactionRepository.existsTransactionByUserCode(1L)).thenReturn(true);

        //Parameters
        TransactionRequestTO transactionRequestTO = new TransactionRequestTO();
        transactionRequestTO.setDestinationCurrency("BRL");
        transactionRequestTO.setBaseCurrency("USD");
        transactionRequestTO.setBaseValue(BigDecimal.valueOf(2));
        transactionRequestTO.setUserId(1L);

        //Test with 200 OK
        ResponseEntity<String> response = testRestTemplate.postForEntity("/currency-converter", transactionRequestTO, String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postConvertTestShouldReturnStatusCode400(){
        //Parameters with currencies not supported
        TransactionRequestTO transactionRequestTO = new TransactionRequestTO();
        transactionRequestTO.setDestinationCurrency("ZZZ");
        transactionRequestTO.setBaseCurrency("AAA");
        transactionRequestTO.setBaseValue(BigDecimal.valueOf(2));
        transactionRequestTO.setUserId(1L);

        //Test with 400 BAD REQUEST
        ResponseEntity<BadRequestDetails> response = testRestTemplate
                .postForEntity("/currency-converter", transactionRequestTO, BadRequestDetails.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(response.getBody().getDetail())
                .isEqualTo("Base currency can just be 'BRL', 'USD', 'EUR' or 'JPY';" +
                        " Base currency can just be 'BRL', 'USD', 'EUR' or 'JPY'; ");

    }

    @Test
    public void getAllTransactionsByIdUserTestShouldReturnStatusCode200(){
        //Mock
        BDDMockito.when(userRepository.existsById(1L)).thenReturn(true);
        BDDMockito.when(transactionRepository.findAllByUserCode(1L)).thenReturn(asList(transaction));

        //Test with 200 OK
        ResponseEntity<String> response = testRestTemplate.getForEntity("/currency-converter/1", String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getAllTransactionsByIdUserTestShouldReturnStatusCode400(){

        //Mock
        BDDMockito.when(transactionRepository.existsTransactionByUserCode(2L)).thenReturn(false);

        //Test with 400 Bad Request
        ResponseEntity<BadRequestDetails> response = testRestTemplate.getForEntity("/currency-converter/1", BadRequestDetails.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(response.getBody().getDetail()).isEqualTo("User ID not found for ID: 1");
    }
}
