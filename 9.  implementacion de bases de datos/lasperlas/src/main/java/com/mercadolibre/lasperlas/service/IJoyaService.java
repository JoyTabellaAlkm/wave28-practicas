package com.mercadolibre.lasperlas.service;

import java.util.List;

import com.mercadolibre.lasperlas.dto.request.CreateJoyaDtoRequest;
import com.mercadolibre.lasperlas.dto.response.CreateJoyaDtoResponse;
import com.mercadolibre.lasperlas.dto.response.DeleteJoyaDtoResponse;
import com.mercadolibre.lasperlas.dto.response.FindJoyaDtoResponse;

public interface IJoyaService {

    public List<FindJoyaDtoResponse> findAll();
    public CreateJoyaDtoResponse save(CreateJoyaDtoRequest request);
    public DeleteJoyaDtoResponse delete(Long id);
    public FindJoyaDtoResponse findById(Long id);

}
