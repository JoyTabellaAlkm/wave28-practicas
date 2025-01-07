package com.bootcamp.social_meli.service;

import com.bootcamp.social_meli.dto.response.AmountOfPromosDTO;
import com.bootcamp.social_meli.dto.response.MostProductsResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsFromFollowsDTO;

import java.util.List;

public interface IProductService {
    AmountOfPromosDTO getAmountOfPromosByUser(Long user_id);
    PostsFromFollowsDTO getAllPostFollowsLastTwoWeeksUnordered(Long userId);
    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Long userId, String order);
    MostProductsResponseDTO getMostProducts();
    MostProductsResponseDTO getMostProducts(String rank);
}
