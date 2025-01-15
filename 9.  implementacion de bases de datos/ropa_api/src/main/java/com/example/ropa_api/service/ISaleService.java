package com.example.ropa_api.service;

import com.example.ropa_api.dto.RequestSaleDto;
import com.example.ropa_api.dto.ResponseDto;
import com.example.ropa_api.model.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    Sale create(RequestSaleDto requestSaleDto);

    List<Sale> getAll();

    Sale show(Long id);

    Sale update(Long id, RequestSaleDto requestSaleDto);

    ResponseDto delete(Long id);

    List<Sale> getAllByDate(LocalDate date);
}
