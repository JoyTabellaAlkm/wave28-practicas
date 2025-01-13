package com.example.jewerly_api.service;

import com.example.jewerly_api.dto.request.RequestJewelDto;
import com.example.jewerly_api.dto.response.ResponseCreateDto;
import com.example.jewerly_api.dto.response.ResponseDto;
import com.example.jewerly_api.dto.response.ResponseUpdateDto;
import com.example.jewerly_api.model.Jewel;

import java.util.List;

public interface IJewelService {
    ResponseCreateDto create(RequestJewelDto requestJewelDto);
    List<Jewel> getAll();
    ResponseDto delete(Long id);

    ResponseUpdateDto update(Long id, RequestJewelDto requestJewelDto);
}
