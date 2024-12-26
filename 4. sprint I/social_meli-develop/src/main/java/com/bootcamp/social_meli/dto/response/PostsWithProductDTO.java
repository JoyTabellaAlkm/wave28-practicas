package com.bootcamp.social_meli.dto.response;

import com.bootcamp.social_meli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostsWithProductDTO {
    private String name;
    private List<Post> posts;

    public PostsWithProductDTO(List<Post> postsWithProduct) {
    }
}
