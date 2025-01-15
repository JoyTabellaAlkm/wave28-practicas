package com.bootcamp.Showroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="clothes")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;
    private String name;
    private String type;
    private String brand;
    private String size;
    private Integer stock;
    @Column(name="sale_price")
    private Double salePrice;
    @ManyToMany
    @JoinTable(name = "cloth_sale",
            joinColumns = @JoinColumn(name = "cloth_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id"))
    List<Sale> sales;
}
