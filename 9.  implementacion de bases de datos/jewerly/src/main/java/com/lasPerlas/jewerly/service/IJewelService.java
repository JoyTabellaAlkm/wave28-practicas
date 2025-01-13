package com.lasPerlas.jewerly.service;

import com.lasPerlas.jewerly.dto.request.NewJewelDTO;
import com.lasPerlas.jewerly.dto.response.JewelDTO;

import java.util.List;

public interface IJewelService {
    Long createJewel(NewJewelDTO jewel);
    List<JewelDTO> getAllJewels();
    JewelDTO getById(Long id);
    JewelDTO deleteById(Long id);
    JewelDTO update(NewJewelDTO jewel, Long id);
}
