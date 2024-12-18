package com.ejercicios.linktracker.services;

import com.ejercicios.linktracker.dtos.requestDto.LinkDTO;
import com.ejercicios.linktracker.dtos.responseDto.LinkIdDTO;

public interface ILinkService {
    public LinkIdDTO addLink(LinkDTO link);
    public String findLink(int id);
}
