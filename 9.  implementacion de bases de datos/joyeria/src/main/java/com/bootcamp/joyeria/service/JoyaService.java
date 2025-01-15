package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.req.JoyaCreationReqDto;
import com.bootcamp.joyeria.dto.res.JoyaGetDto;
import com.bootcamp.joyeria.dto.req.JoyaUpdateReqDto;
import com.bootcamp.joyeria.dto.res.JoyaCreationResDto;
import com.bootcamp.joyeria.dto.res.JoyaUpdateResDto;

import java.util.List;

public interface JoyaService {
    JoyaCreationResDto create(JoyaCreationReqDto joyaDto);
    List<JoyaGetDto> getAll();
    void delete(Long id);
    JoyaUpdateResDto update(Long idJoya, JoyaUpdateReqDto joyaDto);
}
