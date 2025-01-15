package com.example.ropa_api.model;

//numero, fecha, total, medio de pago, lista de prendas.

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Column
    private Double amount;

    @Column
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "sales_clothes",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_id")
    )
    private List<Cloth> clothes;
}
