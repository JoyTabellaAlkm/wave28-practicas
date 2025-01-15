package com.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale_clothings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleClothing {

    @EmbeddedId
    private SaleClothingId id = new SaleClothingId();

    @ManyToOne
    @MapsId("saleNumber")
    @JoinColumn(name = "sale_number")
    private Sale sale;

    @ManyToOne
    @MapsId("clothingCode")
    @JoinColumn(name = "clothing_code")
    private Clothing clothing;

    private Integer quantity;
}
