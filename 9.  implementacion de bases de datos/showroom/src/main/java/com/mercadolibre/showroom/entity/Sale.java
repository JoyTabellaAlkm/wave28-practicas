package com.mercadolibre.showroom.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer number;

    @Column
    private LocalDate date;

    @Column
    private Float total;

    @Column
    private String paymentMethod;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="sale_clothe",
            joinColumns = @JoinColumn (name = "sale_id"),
            inverseJoinColumns = @JoinColumn (name = "clothe_id")
    )
    private List<Clothe> clothes;
}
