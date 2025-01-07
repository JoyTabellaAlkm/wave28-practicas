package com.bootcamp.socialmeli.dto.response;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostPromoResponseDto extends PostDto {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private Double discount;

    public PostPromoResponseDto(Long id,
                                String date,
                                Integer category,
                                Double price,
                                ProductDto productDto,
                                Long uId,
                                boolean hasPromo,
                                Double discount) {
        super(id,date,category,price,productDto);
        this.userId = uId;
        this.discount = discount;
        this.hasPromo = hasPromo;
    }
}
