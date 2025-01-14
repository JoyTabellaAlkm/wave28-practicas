package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.entity.Joya;

import java.util.List;

public interface IJoyaService {
    public List<JoyaDto> getJoyas();
    public long saveJoya(JoyaDto joyaDto);
    public long deleteJoya(long nroIdentificatorio);
    public JoyaDto findJoya(long nroIdentificatorio);
    public long logicDeleteJoya(long nroIdentificatorio);
    public JoyaDto updateJoya (long nroIdentificatorio,JoyaDto joyaDto);
}
