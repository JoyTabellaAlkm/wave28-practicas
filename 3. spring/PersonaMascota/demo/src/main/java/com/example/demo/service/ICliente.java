package com.example.demo.service;

import com.example.demo.dto.request.ClienteDTO;
import com.example.demo.dto.response.ClienteDTOResponse;
import com.example.demo.dto.response.RespuestaDTO;

import java.util.List;

public interface ICliente {
    RespuestaDTO agregarPersona(ClienteDTO clienteDto);

    ClienteDTO obtenerPersona(String nombre);

    List<ClienteDTOResponse> obtenerPersonas();

    ClienteDTO actualizarPersona(String nombre, ClienteDTO clienteDto);

    RespuestaDTO eliminarPersona(String nombre);
}
