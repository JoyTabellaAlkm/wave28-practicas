package com.bootcamp.social_meli.service;

import com.bootcamp.social_meli.dto.PostDTO;
import com.bootcamp.social_meli.dto.PromoPostDTO;
import com.bootcamp.social_meli.dto.response.PostsWithProductDTO;
import com.bootcamp.social_meli.dto.response.MostFollowersResponseDTO;
import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.dto.response.UserPostResponse;
import com.bootcamp.social_meli.model.Post;

import java.util.List;

public interface IPostService {
    UserPostResponse createPost(PostDTO postDTO);
    UserPostResponse createPromoPost(PromoPostDTO promoPostDTO);
    PostsWithProductDTO getPostsWithProduct(String productName);
    MostPostsUsersResponseDTO mostPostsUsers();
    MostPostsUsersResponseDTO mostPostsUsers(Integer rank);
    UserPostResponse updatePromoPost(PromoPostDTO promoPostDTO);
    List<PostDTO> getPostsByPriceRange(String min, String max);
}
