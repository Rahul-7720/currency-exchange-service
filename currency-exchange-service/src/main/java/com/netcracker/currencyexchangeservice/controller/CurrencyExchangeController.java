package com.netcracker.currencyexchangeservice.controller;

import com.netcracker.currencyexchangeservice.entity.Currency;
import com.netcracker.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping(value = "/from/{From_Currency}/to/{To_Currency}")
    public BigDecimal getCurrencyExchangeValue(@PathVariable("From_Currency") String fromCurrency, @PathVariable("To_Currency") String toCurrency) {
        return currencyExchangeService.getExchangeValue(fromCurrency, toCurrency);
    }

    @GetMapping(value = "/clientCall/from/{From_Currency}/to/{To_Currency}")
    public Currency getCurrencyExchangeRecord(@PathVariable("From_Currency") String fromCurrency, @PathVariable("To_Currency") String toCurrency) {
        return currencyExchangeService.getExchangeRecord(fromCurrency, toCurrency);
    }

    @GetMapping(value = "/get-record-by-id/{id}")
    public Currency getCurrencyRecordById(@PathVariable("id") int id) {
        return currencyExchangeService.getCurrencyExchangeRecordById(id);
    }

    @PostMapping(value = "/")
    public Currency addCurrencyRecord(@RequestBody Currency currency) {
        return currencyExchangeService.addCurrencyExchangeRecord(currency);
    }

    @PutMapping(value = "/")
    public Currency modifyCurrencyRecord(@RequestBody Currency currency) {
        return currencyExchangeService.modifyCurrencyExchangeRecord(currency);
    }

    @GetMapping(value = "/")
    public List<Currency> getAllRecords() {
       return  currencyExchangeService.getAllRecordsAtOnce();
    }

}
