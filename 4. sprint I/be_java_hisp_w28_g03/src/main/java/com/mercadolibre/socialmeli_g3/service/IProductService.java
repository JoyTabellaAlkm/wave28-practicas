package com.mercadolibre.socialmeli_g3.service;

import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import com.mercadolibre.socialmeli_g3.dto.PromoProductPostDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> searchProducts(String keyword);
}
