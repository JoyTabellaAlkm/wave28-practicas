package com.mercadolibre.jparelationships.entity.oneToMany.unidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private List<SaleDetail> saleDetails;
}
