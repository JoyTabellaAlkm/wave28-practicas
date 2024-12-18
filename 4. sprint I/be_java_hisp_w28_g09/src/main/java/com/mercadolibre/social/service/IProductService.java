package com.mercadolibre.social.service;

import com.mercadolibre.social.dto.ProductSearchDto;
import com.mercadolibre.social.dto.response.PostDetailsDTO;
import com.mercadolibre.social.dto.response.ProductCountPromoPostDto;

import java.util.List;

public interface IProductService {
    List<PostDetailsDTO> search(String query, String rangePrice);
}
