package com.api.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByCategoryResponseDto {
    private String category_description;
    private List<PostDto> posts;
}
