package com.ar.mercadolibre.joyerialasperlas.service;

import com.ar.mercadolibre.joyerialasperlas.dto.CreateMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.DeleteMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.JewelryDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.UpdateMessageDTO;

import java.util.List;

public interface IJewelryService {
    CreateMessageDTO create(JewelryDTO jewelryDTO);
    List<JewelryDTO> getAll();
    DeleteMessageDTO delete(Long id);
    UpdateMessageDTO update(Long idToModify, JewelryDTO jewelryDTO);
}
