package com.netcracker.currencyexchangeservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CurrencyRecordTable")
public class Currency {

    @Id
    private int id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal value;

}
