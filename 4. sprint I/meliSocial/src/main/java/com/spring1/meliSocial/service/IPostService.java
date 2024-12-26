package com.spring1.meliSocial.service;

import com.spring1.meliSocial.dto.request.RequestPostDto;

import com.spring1.meliSocial.dto.request.ProductPromoDto;

import com.spring1.meliSocial.dto.response.PostIndexDto;
import com.spring1.meliSocial.dto.response.PostPromoDto;
import com.spring1.meliSocial.dto.response.ResponseDto;
import com.spring1.meliSocial.dto.response.ResponsePostDto;

import java.util.List;


public interface IPostService {

    ResponseDto saveNewPost(RequestPostDto requestPostDto);

    ResponseDto addNewProductPromo(ProductPromoDto product);

    PostIndexDto getPostsByUser(int userId, String order);

    PostPromoDto getProductsOnPromo(int userId);

    List<ResponsePostDto> getBestProductsOnPromo(Integer category);

    ResponseDto updatePromoDiscount(int id, double discount);

    List<ResponsePostDto> getAll();

    ResponseDto updatePrice(int id, double price);

}
