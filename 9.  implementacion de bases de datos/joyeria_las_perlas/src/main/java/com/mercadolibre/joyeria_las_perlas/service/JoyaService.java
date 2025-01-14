package com.mercadolibre.joyeria_las_perlas.service;

import com.mercadolibre.joyeria_las_perlas.dto.request.JoyaRequestDTO;
import com.mercadolibre.joyeria_las_perlas.dto.response.JoyaDTO;

import java.util.List;

public interface JoyaService {
    public List<JoyaDTO> getAll();
    public JoyaDTO save(JoyaDTO joya);
    public boolean delete(long id);
    public JoyaDTO findById(long id);
    public JoyaDTO edit(Long id, JoyaRequestDTO joyaRequestDTO);
}
