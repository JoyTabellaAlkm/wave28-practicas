package com.api.social_meli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Identifiable{
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_name")
    private String name;
    private String type;
    private String brand ;
    @JsonProperty("color")
    private String colour;
    private String notes;

    @Override
    public int getId() {
        return this.productId;
    }

    @Override
    public void setId(int id) { this.productId = id; }
}
