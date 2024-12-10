package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkRequestDto;
import com.mercadolibre.linktracker.dto.LinkResponseDto;

public interface ILinkService {
    LinkResponseDto createLink(LinkRequestDto link);

    String redirect(Integer id, String password);

    Integer getMetrics(Integer id);

    String invalidateLink(Integer id);
}
