package com.bootcamp.clothes.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double total;

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "sale_clothes",
            joinColumns = @JoinColumn(name = "sale_number"),
            inverseJoinColumns = @JoinColumn(name = "clothe_code")
    )
    private Set<Clothe> clothes;
}