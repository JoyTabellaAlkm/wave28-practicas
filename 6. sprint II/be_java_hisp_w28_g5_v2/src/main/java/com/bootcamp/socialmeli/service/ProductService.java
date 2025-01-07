package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.PromoProductsCountDto;
import com.bootcamp.socialmeli.dto.request.PostPromoRequestDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedProductsDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    public GetFollowedProductsDto followedProducts(Long userId, Optional<String> type_order);
    PostDto createPost(PostCreationDto postDto);
    PostPromoDto createPostWithDiscount(PostPromoRequestDto postPromoDto);

    PromoProductsCountDto getPromoProductCount(Long id);
}
