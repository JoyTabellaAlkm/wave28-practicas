package com.bootcamp.social_meli.service;

import com.bootcamp.social_meli.dto.request.PostDTO;
import com.bootcamp.social_meli.dto.request.PromoPostDTO;
import com.bootcamp.social_meli.dto.response.PostsWithProductResponseDTO;
import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.dto.response.UserPostResponse;

import java.util.List;

public interface IPostService {
    UserPostResponse createPost(PostDTO postDTO);
    UserPostResponse createPromoPost(PromoPostDTO promoPostDTO);
    PostsWithProductResponseDTO getPostsWithProduct(String productName);
    MostPostsUsersResponseDTO mostPostsUsers();
    MostPostsUsersResponseDTO mostPostsUsers(Integer rank);
    UserPostResponse updatePromoPost(PromoPostDTO promoPostDTO);
    List<PostDTO> getPostsByPriceRange(String min, String max);
}
