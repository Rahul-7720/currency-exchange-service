package com.netcracker.currencyexchangeservice.service;

import com.netcracker.currencyexchangeservice.entity.Currency;
import com.netcracker.currencyexchangeservice.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;



@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency addCurrencyExchangeRecord(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency modifyCurrencyExchangeRecord(final Currency currency) {
        return addCurrencyExchangeRecord(currency);
    }

    @Override
    public BigDecimal getExchangeValue(String fromCurrency, String toCurrency) {
        try {
            return (getExchangeRecord(fromCurrency, toCurrency).getValue());
        } catch(NullPointerException e) {
            return null;
        }
    }

    @Override
    public Currency getCurrencyExchangeRecordById(int id) {
        return currencyRepository.findById(id).orElse(new Currency());
    }

    @Override
    public List<Currency> getAllRecordsAtOnce() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getExchangeRecord(String fromCurrency, String toCurrency) {
        return currencyRepository.getRecordUsingFromAndTo(fromCurrency,toCurrency);
    }

}














//      public Currency modifyCurrencyExchangeRecord(final Currency currency) {
//        Redundant logic as jpa will automatically take care if record is present or not
//        int currentRecord = currency.getId();
//        if(currencyRepository.existsById(currentRecord)) {
//            currencyRepository.getById(currentRecord).setValue(currency.getValue());
//            currencyRepository.getById(currentRecord).setToCurrency(currency.getToCurrency());
//            currencyRepository.getById(currentRecord).setFromCurrency(currency.getFromCurrency());
//            return "Currency record Modified Successfully";
//        }
//        return addCurrencyExchangeRecord(currency);
//      }



//    public Currency getCurrencyExchangeRecordById(int id) {
//        // will throw NoSuchElementFound Exception if the record is absent
//        return currencyRepository.findById(id).get();
//        // throw exception related to serializable
//        return currencyRepository.getById(id);
//        // will show empty response if record is absent As i have just written the query for it
//        return currencyRepository.getRecordById();
//        // will return an null record using orElse when record is absent
//         return currencyRepository.findById(id).orElse(new Currency());
//    }




//    public BigDecimal getExchangeValue(String fromCurrency, String toCurrency) {
//        List<Currency> filteredList = currencyRepository.findAll().stream()
//                .filter(x->x.getFromCurrency().equals(fromCurrency))
//                .filter(x->x.getToCurrency().equals(toCurrency))
//                .collect(Collectors.toList());
//
//        if(filteredList.size()==0) return BigDecimal.valueOf(-1);
//        return (filteredList.get(0).getValue());
//  }



