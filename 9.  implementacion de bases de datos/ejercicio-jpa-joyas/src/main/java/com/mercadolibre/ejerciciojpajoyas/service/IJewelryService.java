package com.mercadolibre.ejerciciojpajoyas.service;

import com.mercadolibre.ejerciciojpajoyas.dto.CreateJewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.EditJewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.JewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IJewelryService {

    MessageDTO createJewelry(CreateJewelryDTO createJewelryDTO);

    List<JewelryDTO> getAllJewelry();

    MessageDTO softDeleteJewelry(Long id);

    JewelryDTO editJewelry(Long id, EditJewelryDTO editJewelryDTO);

}
