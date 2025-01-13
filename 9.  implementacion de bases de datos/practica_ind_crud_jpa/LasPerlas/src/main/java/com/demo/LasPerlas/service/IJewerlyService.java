package com.demo.LasPerlas.service;

import com.demo.LasPerlas.dto.JewelDto;

import java.util.List;

public interface IJewerlyService {
    Long post(JewelDto jewelDto);
    List<JewelDto> getAll();
    void delete(Long id);
    void update(Long id, JewelDto jewelDto);
}
