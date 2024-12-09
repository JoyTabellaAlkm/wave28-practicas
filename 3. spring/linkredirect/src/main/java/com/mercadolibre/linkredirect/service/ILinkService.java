package com.mercadolibre.linkredirect.service;

import com.mercadolibre.linkredirect.dto.LinkDtoRequest;
import com.mercadolibre.linkredirect.dto.LinkDtoResponse;
import com.mercadolibre.linkredirect.model.Link;

import java.util.List;

public interface ILinkService {
    Long addLink(LinkDtoRequest linkDtoRequest);
    List<LinkDtoResponse> getAll();
    LinkDtoResponse getById(Long id);

    LinkDtoResponse viewLinkById(Long id, String password);

    Long toggleLinkValid(Long id);
}
