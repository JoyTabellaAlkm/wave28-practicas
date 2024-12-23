package com.example.demo.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTOResponse {

    private String nombreCompleto;
    private List<MascotaDTOResponse> mascotasList;


}
