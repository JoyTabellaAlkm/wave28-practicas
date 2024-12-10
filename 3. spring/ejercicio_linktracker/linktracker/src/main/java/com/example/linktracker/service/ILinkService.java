package com.example.linktracker.service;

import com.example.linktracker.dto.LinkResponseDTO;
import com.example.linktracker.dto.MetricsResponseDTO;

public interface ILinkService {
    LinkResponseDTO createLink(String link);
    String getLinkById(int id);
    MetricsResponseDTO getMetrics(int id);
    void invalidate(int id);
}
