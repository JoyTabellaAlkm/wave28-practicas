package com.example.ropa_api.service;

import com.example.ropa_api.dto.RequestClothDto;
import com.example.ropa_api.dto.ResponseDto;
import com.example.ropa_api.model.Cloth;

import java.util.List;

public interface IClothService {
    Cloth create(RequestClothDto requestTestCaseDto);

    List<Cloth> getAll(String name, Long number);

    Cloth show(Long id);

    Cloth update(Long id, RequestClothDto requestTestCaseDto);

    ResponseDto delete(Long id);

    List<Cloth> getAllBySize(String size);
}
