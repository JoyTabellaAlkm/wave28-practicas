package com.mercadolibre.socialmeli_g3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPostsDTO {
    private int userId;
    private List<PostDTO> posts;
}
