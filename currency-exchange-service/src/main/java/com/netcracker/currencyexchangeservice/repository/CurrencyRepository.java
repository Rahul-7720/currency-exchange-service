package com.netcracker.currencyexchangeservice.repository;

import com.netcracker.currencyexchangeservice.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    @Query("Select c from Currency c where c.fromCurrency = ?1 and c.toCurrency = ?2")
    Currency getRecordUsingFromAndTo(String from, String to);

    @Query("select c from Currency c where c.id = ?1")
    Currency getRecordById(Integer id);

}
