package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostsFromFollowsDTO {
    private Long user_id;
    private List<PostNoDiscountDTO> posts;
}