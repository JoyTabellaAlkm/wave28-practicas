package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class FollowedSellerPostsDto {
    @Min(value = 1, message = "El id debe ser mayor a cero")
    @NotNull(message = "El id no puede estar vacio")
    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDto> posts;
}
