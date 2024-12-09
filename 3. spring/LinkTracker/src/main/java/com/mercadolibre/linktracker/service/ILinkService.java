package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.Request.LinkRequestDTO;
import com.mercadolibre.linktracker.dto.Response.LinkInvalidatedDTO;
import com.mercadolibre.linktracker.dto.Response.LinkMetricsResponseDTO;
import com.mercadolibre.linktracker.dto.Response.LinkResponseDTO;

public interface ILinkService {

    public LinkResponseDTO crearLink(LinkRequestDTO link);
    public String redirect(Long id);
    public LinkMetricsResponseDTO obtenerMetricas(Long id);
    public LinkInvalidatedDTO invalidarLink(Long id);
}
