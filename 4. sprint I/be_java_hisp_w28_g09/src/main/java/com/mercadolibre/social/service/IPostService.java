package com.mercadolibre.social.service;

import com.mercadolibre.social.dto.request.PostPromotionRequestDto;
import com.mercadolibre.social.dto.request.PostRequestDto;
import com.mercadolibre.social.dto.response.MessageDto;
import com.mercadolibre.social.dto.response.ProductCountPromoPostDto;
import com.mercadolibre.social.dto.response.UserPostsResponseDTO;
import com.mercadolibre.social.entity.Post;



public interface IPostService {
    MessageDto createPost(PostRequestDto postRequestDTO);

    ProductCountPromoPostDto getCountPromoPost(int userId);

    MessageDto createPostPromotion(PostPromotionRequestDto postPromotionRequestDto);

    UserPostsResponseDTO getPostsByFollowedUsers(Integer userId, String order);

}
