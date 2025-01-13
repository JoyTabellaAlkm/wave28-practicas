package com.joyeria.service;

import com.joyeria.dto.JoyaDTO;

import java.util.List;

public interface IJoyeriaService {
    public JoyaDTO createJoya(JoyaDTO joyaDTO);
    public List<JoyaDTO> findAllJoyas();
    public JoyaDTO findJoyaById(int id);
    public JoyaDTO updateJoya(int id, JoyaDTO joyaDTO);
    public String deleteJoya(int id);
}
