package com.mercadolibre.ejercicioextrashowroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDate date;

    Double total;

    String paymentType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    Set<Clothes> items = new HashSet<>();


    public void calculateTotal() {
        Double total = 0.0;
        for(Clothes i: items) {
            total += i.getPrice() * i.getQuantity();
        }
        this.total = total;
    }

}
