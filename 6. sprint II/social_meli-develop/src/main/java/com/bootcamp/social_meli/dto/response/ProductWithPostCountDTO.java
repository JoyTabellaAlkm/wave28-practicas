package com.bootcamp.social_meli.dto.response;

import com.bootcamp.social_meli.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithPostCountDTO extends ProductDTO {
    private long products_count;

    public ProductWithPostCountDTO(Long product_id, String product_name, String type, String brand, String color, String notes, long products_count) {
        super(product_id, product_name, type, brand, color, notes);
        this.products_count = products_count;
    }
}
