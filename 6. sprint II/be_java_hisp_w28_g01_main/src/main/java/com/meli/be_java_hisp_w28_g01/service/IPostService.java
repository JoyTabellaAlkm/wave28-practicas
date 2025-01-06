package com.meli.be_java_hisp_w28_g01.service;

import com.meli.be_java_hisp_w28_g01.dto.request.PostDto;
import com.meli.be_java_hisp_w28_g01.dto.response.PostByUserDto;
import com.meli.be_java_hisp_w28_g01.dto.request.PromoPostDto;
import com.meli.be_java_hisp_w28_g01.dto.response.ResponsePostDto;
import com.meli.be_java_hisp_w28_g01.dto.response.PromoPostCountDto;

import java.util.List;

public interface IPostService {
    List<ResponsePostDto> getAll();
    ResponsePostDto getByid(int id);
    String add(PostDto postDto);
    String addPromoPost(PromoPostDto promoPostDto);
    PostByUserDto getPostsByUser(int userId);

    PromoPostCountDto getPromoPostCount(int user_id);

    PostByUserDto getPostByUserOrderedByDate(int userId, String order);

    List<ResponsePostDto> getByProductType(String productType);
}
