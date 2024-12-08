package com.example.deportistas.service;

import com.example.deportistas.dto.SportDTO;

import java.util.List;

public interface ISportService {
    List<SportDTO> getSports();
    SportDTO getSportByName(String name);
}
