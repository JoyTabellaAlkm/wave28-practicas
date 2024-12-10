package com.ar.mercadolibre.linktracker.service;

import com.ar.mercadolibre.linktracker.dto.request.LinkRequestDto;
import com.ar.mercadolibre.linktracker.dto.respoonse.LinkDto;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkService {
    LinkDto createMaskedUrl(String linkId, LinkRequestDto linkRequestDto);
    String redirect(String linkId, String password);
    long getMetricsById(String linkID);
    void delete(String linkID);
}

