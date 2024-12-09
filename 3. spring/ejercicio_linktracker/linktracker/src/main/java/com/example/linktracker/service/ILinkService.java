package com.example.linktracker.service;

import com.example.linktracker.dto.LinkResponseDTO;

public interface ILinkService {
    LinkResponseDTO createLink(String link);
    String getLinkById(int id);
}
