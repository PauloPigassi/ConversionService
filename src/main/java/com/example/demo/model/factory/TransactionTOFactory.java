package com.example.demo.model.factory;

import java.math.BigDecimal;

import com.example.demo.model.entity.Transaction;
import com.example.demo.model.to.TransactionTO;

/**
 * Factory to create a {@link com.paulopigassi.conversordemoedas.model.to.TransactionTO} object
 * @author Paulo Pigassi
 */
public class TransactionTOFactory {

    /**
     * Creates a {@link com.paulopigassi.conversordemoedas.model.to.TransactionTO} object
     * by {@link com.paulopigassi.conversordemoedas.model.to.TransactionTO} object
     * @param transaction {@link com.paulopigassi.conversordemoedas.model.entity.Transaction} object
     * @return {@link com.paulopigassi.conversordemoedas.model.to.TransactionTO}
     */
    public static TransactionTO create(Transaction transaction){
        TransactionTO transactionTO = new TransactionTO();
        transactionTO.setId(transaction.getUserCode().getUserCode());
        transactionTO.setUserId(transaction.getUserCode().getUserCode());
        transactionTO.setBaseCurrency(transaction.getBaseCurrency().getText());
        transactionTO.setBaseValue(transaction.getBaseValue());
        transactionTO.setDestinationCurrency(transaction.getDestinationCurrency().getText());
        transactionTO.setDestinationValue(getDestinationValue(transaction.getBaseValue(), transaction.getConversionTax()));
        transactionTO.setConversionTax(transaction.getConversionTax());
        transactionTO.setDate(transaction.getDate().toString());

        return transactionTO;
    }

    /**
     * Calculates destination value
     * @param baseValue {@link java.math.BigDecimal} base value
     * @param conversionTax {@link java.math.BigDecimal} conversion tax
     * @return {@link java.math.BigDecimal}
     */
    private static BigDecimal getDestinationValue(BigDecimal baseValue, BigDecimal conversionTax) {
        return baseValue.multiply(conversionTax).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
