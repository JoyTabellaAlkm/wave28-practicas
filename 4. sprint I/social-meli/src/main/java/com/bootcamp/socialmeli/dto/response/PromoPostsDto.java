package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PromoPostsDto {
    @JsonProperty("user_id")
    int userId;

    @JsonProperty("user_name")
    String userName;
    
    @JsonProperty("promo_products_count")
    int count;
}
