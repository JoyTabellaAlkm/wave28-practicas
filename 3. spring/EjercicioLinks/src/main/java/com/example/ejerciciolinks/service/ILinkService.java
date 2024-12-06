package com.example.ejerciciolinks.service;

import com.example.ejerciciolinks.dto.LinkDTO;
import com.example.ejerciciolinks.dto.LinkMetricDTO;

public interface ILinkService {
    Integer saveLink(LinkDTO link);

    void invalidateLink(Integer linkId);

    LinkMetricDTO getLinkMetrics(Integer linkId);

    LinkDTO redirect(Integer linkId, String password);
}
