package com.mercadolibre.social.service;

import com.mercadolibre.social.dto.response.PostDetailsDTO;

import java.util.List;

public interface IProductService {
    List<PostDetailsDTO> search(String query, String rangePrice);
}
