package com.example.demo.model.factory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.model.entity.CurrencyEnum;
import com.example.demo.model.entity.Transaction;
import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.ExchangeRatesTO;
import com.example.demo.model.to.Rates;
import com.example.demo.model.to.TransactionRequestTO;

/**
 * Factory to create a {@link com.paulopigassi.conversordemoedas.model.entity.Transaction} object
 * @author Paulo Pigassi
 */
public class TransactionFactory {

    /**
     * Creates a {@link com.paulopigassi.conversordemoedas.model.entity.Transaction} object
     * by {@link com.paulopigassi.conversordemoedas.model.to.TransactionRequestTO}
     * and {@link com.paulopigassi.conversordemoedas.model.to.ExchangeRatesTO}
     * @param transactionRequestTO {@link com.paulopigassi.conversordemoedas.model.to.TransactionRequestTO} request object
     * @param exchangeRatesTO {@link com.paulopigassi.conversordemoedas.model.to.ExchangeRatesTO} exchange rates API result object
     * @return {@link com.paulopigassi.conversordemoedas.model.entity.Transaction}
     */
    public static Transaction create(TransactionRequestTO transactionRequestTO, ExchangeRatesTO exchangeRatesTO) {
        Transaction transaction = new Transaction();
        transaction.setUserCode(new UserTransaction());
        transaction.getUserCode().setUserCode(transactionRequestTO.getUserId());
        transaction.setBaseCurrency(CurrencyEnum.getCurrencyEnumByText(transactionRequestTO.getBaseCurrency()));
        transaction.setBaseValue(transactionRequestTO.getBaseValue());
        transaction.setDestinationCurrency(CurrencyEnum.getCurrencyEnumByText(transactionRequestTO.getDestinationCurrency()));
        transaction.setConversionTax(getConversionTax(exchangeRatesTO.getRates(), transactionRequestTO.getDestinationCurrency()));
        transaction.setDate(LocalDateTime.now());

        return transaction;
    }

    /**
     * Get conversion tax value by currency
     * @param rates {@link com.paulopigassi.conversordemoedas.model.to.Rates} rates API result object
     * @param baseCurrency {@link java.lang.String} base currency text
     * @return {@link java.math.BigDecimal}
     */
    private static BigDecimal getConversionTax(Rates rates, String baseCurrency) {
        switch (baseCurrency){
            case "BRL":
                return rates.getBrl();
            case "USD":
                return rates.getUsd();
            case "EUR":
                return rates.getEur();
            case "JPY":
                return rates.getJpy();
            default:
                return BigDecimal.ZERO;
        }
    }

}
