package com.bootcamp.social_meli.dto.response;

import com.bootcamp.social_meli.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostNoDiscountResponseDTO {
    private Long user_id;
    private Long post_id;
    private LocalDate createDate;
    private ProductDTO product;
    private Integer category;
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostNoDiscountResponseDTO that = (PostNoDiscountResponseDTO) o;
        return Objects.equals(user_id, that.user_id) &&
                Objects.equals(post_id, that.post_id) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(product, that.product) &&
                Objects.equals(category, that.category) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, post_id, createDate, product, category, price);
    }
}
