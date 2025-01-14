package com.mercadolibre.purchases.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseKey implements Serializable {
    private Long customerId;
    private LocalDate date;
}
