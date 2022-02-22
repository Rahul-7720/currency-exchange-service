package com.netcracker.currencyexchangeservice.service;

import com.netcracker.currencyexchangeservice.entity.Currency;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyExchangeService {
    Currency addCurrencyExchangeRecord(Currency currency);
    Currency modifyCurrencyExchangeRecord(Currency currency);
    BigDecimal getExchangeValue(String fromCurrency, String toCurrency);
    Currency getCurrencyExchangeRecordById(int id);
    List<Currency> getAllRecordsAtOnce();
    Currency getExchangeRecord(String fromCurrency,String toCurrency);
}
