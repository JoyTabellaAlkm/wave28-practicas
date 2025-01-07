package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostDto> createPosts(List<PostCreationDto> postsDto);

    List<PostPromoDto> getPosts(Optional<Integer> category);
}
