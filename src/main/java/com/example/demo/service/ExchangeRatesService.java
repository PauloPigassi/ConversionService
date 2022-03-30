package com.example.demo.service;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.error.BadRequestException;
import com.example.demo.model.to.ExchangeRatesTO;

import ch.qos.logback.classic.Logger;

/**
 * Service class for accessing the exchange rates API
 * @author Paulo Pigassi
 */
@Service
public class ExchangeRatesService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(ExchangeRatesService.class);

    /**
     * Get exchange rates by <a href="https://api.exchangeratesapi.io/">api.exchangeratesapi.io</a>
     * @param baseCurrency {@link java.lang.String} for base currency text
     * @param destinationCurrency {@link java.lang.String} for base destination text
     * @return {@link com.paulopigassi.conversordemoedas.model.to.ExchangeRatesTO}
     * @throws BadRequestException {@link BadRequestException}
     */
    public ExchangeRatesTO getExchangeRatesTO(String baseCurrency, String destinationCurrency) throws BadRequestException {
        String uri = String.format("https://api.exchangerate.host/latest?base=%s&symbols=%s", baseCurrency, destinationCurrency);
        RestTemplate restTemplate = new RestTemplate();
        ExchangeRatesTO result;

        try{
            result = restTemplate.getForObject(uri, ExchangeRatesTO.class);
        }catch (RestClientException e){
            logger.error(String.format("Exchange rates API error: %s", e.getMessage()));
            throw new BadRequestException("Exchange rates API not responding");
        }

        logger.info(String.format("Exchange rates object: %s", result.toString()));
        return result;
    }
}
