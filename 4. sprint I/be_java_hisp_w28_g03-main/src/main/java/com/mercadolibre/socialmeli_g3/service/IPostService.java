package com.mercadolibre.socialmeli_g3.service;


import com.mercadolibre.socialmeli_g3.dto.*;
import com.mercadolibre.socialmeli_g3.dto.response.ProductByIdUserResponseDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FindProductsPromoResponseDTO;
import com.mercadolibre.socialmeli_g3.entity.Post;

import java.util.List;
import java.util.Map;

public interface IPostService {

    List<Post> getPosts();
    ProductByIdUserResponseDTO findProductByIdUser(int userId, String order);
    FindProductsPromoResponseDTO findProductsPromoCount(int userId);
    MessageDTO createPost(ProductPostDTO productPostDTO);
    MessageDTO createPromoPost(PromoProductPostDTO promoProductPostDTO);
    PromoProductPostListDTO getProductsOnPromoByUser(String userId);
    List<PostDTO> findProductByPrice(double minPrice, double maxPrice);
    List<PostDTO> findProductsByCategory(int category);
    List<PostDTO> getPostsByProductAttributes(Map<String, String> filterParams);
    PromoProductPostDTO makePostAPromo(int postId,double discount);
}
