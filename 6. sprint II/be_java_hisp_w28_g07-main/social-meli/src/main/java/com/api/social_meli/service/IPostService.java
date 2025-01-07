package com.api.social_meli.service;

import com.api.social_meli.dto.*;
import com.api.social_meli.dto.PromoPostDto;

import java.util.List;

public interface IPostService {
    PostDto getPostById(int postId);
    List<PostDto> getPosts();
    List<PostDto> getPostsByUserId(int userId);
    PromoPostCountDto getPromoProductCount(Integer userId);
    MessageDto createPromoPost(PromoPostDto dto);
    MessageDto createPost(PostDto dto);
    FollowedSellerPostsDto getFollowedSellersPosts(int userId, String order);
    GetByCategoryResponseDto getPostByCategoryId(int categoryId, double price_min, double price_max);
}
