package com.example.demo.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {

    private String nombre;
    private String apellido;
    private List<MascotaDTO> mascotasList;


}
