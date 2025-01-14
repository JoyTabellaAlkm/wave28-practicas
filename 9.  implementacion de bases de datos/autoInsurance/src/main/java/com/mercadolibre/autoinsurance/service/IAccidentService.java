package com.mercadolibre.autoinsurance.service;

import com.mercadolibre.autoinsurance.dto.request.AccidentRequestDto;
import com.mercadolibre.autoinsurance.dto.response.AccidentResponseDto;

import java.util.List;

public interface IAccidentService {
    AccidentResponseDto save(AccidentRequestDto accidentRequestDto);

    List<AccidentResponseDto> findAll();
}
