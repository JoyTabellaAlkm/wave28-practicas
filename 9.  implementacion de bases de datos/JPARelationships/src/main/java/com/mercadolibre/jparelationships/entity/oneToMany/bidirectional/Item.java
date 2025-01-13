package com.mercadolibre.jparelationships.entity.oneToMany.bidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detail;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
