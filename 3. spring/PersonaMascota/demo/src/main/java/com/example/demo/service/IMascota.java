package com.example.demo.service;

import com.example.demo.dto.request.ClienteDTO;
import com.example.demo.dto.request.MascotaDTO;

public interface IMascota {
    MascotaDTO agregarMascota(ClienteDTO clienteDTO);

    MascotaDTO obtenerMascota(String nombre);
}
