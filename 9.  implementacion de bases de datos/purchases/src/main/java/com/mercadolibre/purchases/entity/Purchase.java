package com.mercadolibre.purchases.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
@IdClass(value = PurchaseKey.class)
public class Purchase {
    @Id
    @Column(name = "customer_id")
    private Long customerId;
    @Id
    private LocalDate date;
    @Column(name = "total_value")
    private Double totalValue;
    private String details;
}
