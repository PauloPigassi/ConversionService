package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.error.BadRequestException;
import com.example.demo.model.entity.Transaction;
import com.example.demo.model.factory.TransactionFactory;
import com.example.demo.model.factory.TransactionTOFactory;
import com.example.demo.model.to.ExchangeRatesTO;
import com.example.demo.model.to.TransactionRequestTO;
import com.example.demo.model.to.TransactionTO;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;

/**
 * Service class for management of transaction request object and to access repository
 * @author Paulo Pigassi
 */
@Service
public class CurrencyConverterService {

    private final Logger logger = LoggerFactory.getLogger(CurrencyConverterService.class);

    private final ExchangeRatesService exchangeRatesService;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    /**
     * Default constructor
     * @param exchangeRatesService {@link ExchangeRatesService} exchange rates service object
     * @param transactionRepository {@link TransactionRepository} transaction repository object
     * @param userRepository {@link UserRepository} user repository object
     */
    public CurrencyConverterService(ExchangeRatesService exchangeRatesService,
                                    TransactionRepository transactionRepository, UserRepository userRepository) {
        this.exchangeRatesService = exchangeRatesService;
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    /**
     * Get {@link com.paulopigassi.conversordemoedas.model.to.TransactionRequestTO} object,
     * call Exchange Rates API,
     * save {@link com.paulopigassi.conversordemoedas.model.entity.Transaction} data,
     * and build the result data
     * @param transactionRequestTO {@link com.paulopigassi.conversordemoedas.model.to.TransactionRequestTO} data from request
     * @return {@link com.paulopigassi.conversordemoedas.model.to.TransactionTO}
     * @throws BadRequestException {@link com.paulopigassi.conversordemoedas.error.BadRequestException}
     */
    public TransactionTO convert(TransactionRequestTO transactionRequestTO) throws BadRequestException {

        //call rest template service for 'exchangerates.io'
        ExchangeRatesTO exchangeRatesTO = exchangeRatesService.getExchangeRatesTO(
                transactionRequestTO.getBaseCurrency(),
                transactionRequestTO.getDestinationCurrency());

        //save transaction data
        Transaction transaction =  TransactionFactory.create(transactionRequestTO, exchangeRatesTO);
        transactionRepository.save(transaction);
        logger.info(String.format("transaction saved: %s", transaction));

        //change exchangeRatesTO object to TransactionTO
        return TransactionTOFactory.create(transaction);
    }

    /**
     * Get all transactions by IdUser
     * @param idUser id number for user
     * @return {@link java.util.List}
     * @throws BadRequestException {@link com.paulopigassi.conversordemoedas.error.BadRequestException}
     */
    public List<TransactionTO> getAllTransactionsByUserCode(Long idUser) throws BadRequestException {
        //verifyIfUserExists();
        List<Transaction> transactionList = transactionRepository.findAllByUserCode(idUser);
        logger.info(String.format("transaction list for id: %s - %s", idUser, transactionList));
        return transactionList.stream().map(transaction ->
                TransactionTOFactory.create(transaction)).collect(Collectors.toList());
    }

    /**
     * Verify if user exists by id number
     * @param idUser id number for user
     * @throws BadRequestException {@link com.paulopigassi.conversordemoedas.error.BadRequestException}
     */
//    private void verifyIfUserExists() throws BadRequestException {
//        if(!userRepository.existsByUserCode()){
//            logger.warn(String.format("user with id: %s not exists", 1));
//            throw new BadRequestException("User ID not found for ID: "+1);
//        }
//        logger.info(String.format("user with id: %s exists", 1));
//    }

}
