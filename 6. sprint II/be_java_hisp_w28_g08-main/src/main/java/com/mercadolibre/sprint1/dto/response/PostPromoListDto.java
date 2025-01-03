package com.mercadolibre.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint1.dto.util.PostPromoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoListDto {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String name;

    private List<PostPromoDto> posts;
}
