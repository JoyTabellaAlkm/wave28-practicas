package com.bootcamp.social_meli.service;

import com.bootcamp.social_meli.dto.response.AmountOfPromosResponseDTO;
import com.bootcamp.social_meli.dto.response.MostProductsResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsFromFollowsResponseDTO;

public interface IProductService {
    AmountOfPromosResponseDTO getAmountOfPromosByUser(Long user_id);
    PostsFromFollowsResponseDTO getAllPostFollowsLastTwoWeeksUnordered(Long userId);
    PostsFromFollowsResponseDTO getAllPostsFollowsLastTwoWeeks(Long userId, String order);
    MostProductsResponseDTO getMostProducts();
    MostProductsResponseDTO getMostProducts(String rank);
}
