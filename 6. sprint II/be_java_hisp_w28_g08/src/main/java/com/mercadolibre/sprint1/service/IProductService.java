package com.mercadolibre.sprint1.service;

import com.mercadolibre.sprint1.dto.request.CreatePromoPostDto;
import com.mercadolibre.sprint1.dto.request.NewPostDto;
import com.mercadolibre.sprint1.dto.response.PostPromoListDto;
import com.mercadolibre.sprint1.dto.response.ProductsFollowedDtoResponse;
import com.mercadolibre.sprint1.dto.response.CountProductsPromoDto;

public interface IProductService {
    String createPromoPost(CreatePromoPostDto postPromo);
    ProductsFollowedDtoResponse productsOfPeopleFollowed(int id, String order);
    String newPost(NewPostDto newPostDto);

    PostPromoListDto listProductsPromo(int userId);

    CountProductsPromoDto findPromoProductsBySeller(int userId);

}
