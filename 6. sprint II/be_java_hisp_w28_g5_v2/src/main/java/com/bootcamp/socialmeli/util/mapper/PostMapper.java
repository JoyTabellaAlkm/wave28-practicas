package com.bootcamp.socialmeli.util.mapper;

import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.request.PostPromoRequestDto;
import com.bootcamp.socialmeli.dto.response.PostResponseDto;
import com.bootcamp.socialmeli.model.Post;

public class PostMapper {
    private PostMapper() {}

    public static PostResponseDto toPostResponseDto(Post p,Long uId){
        return new PostResponseDto(
                p.getId(),
                DateMapper.toString(p.getDate()),
                p.getCategory(),
                p.getPrice(),
                ProductMapper.toProductDto(p.getProduct()),
                        uId
        );
    }
    public static PostDto toPostDto(Post p) {
        return new PostDto(
                p.getId(),
                DateMapper.toString(p.getDate()),
                p.getCategory(),
                p.getPrice(),
                ProductMapper.toProductDto(p.getProduct())
        );
    }

    public static PostPromoDto toPostPromoDto(Post p) {
        return new PostPromoDto(
                p.getId(),
                DateMapper.toString(p.getDate()),
                p.getCategory(),
                p.getPrice(),
                ProductMapper.toProductDto(p.getProduct()),
                p.isHasPromo(),
                p.getDiscount()
        );
    }

    public static Post toPost(PostCreationDto postDto){
        return new Post(
                null,
                DateMapper.toLocalDate(postDto.getDate()),
                ProductMapper.toProductNew(postDto.getProduct()),
                postDto.getCategory(),
                postDto.getPrice(),
                false,
                null
        );
    }

    public static Post toPost(PostPromoRequestDto postDto){
        return new Post(
                null,
                DateMapper.toLocalDate(postDto.getDate()),
                ProductMapper.toProductNew(postDto.getProduct()),
                postDto.getCategory(),
                postDto.getPrice(),
                postDto.isHasPromo(),
                postDto.getDiscount()
        );
    }
}
