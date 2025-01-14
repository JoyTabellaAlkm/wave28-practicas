package com.example.demo.service;

import com.example.demo.dto.request.ClienteDTO;
import com.example.demo.dto.request.MascotaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaServiceImpl implements IMascota {

    List<MascotaDTO> mascotaList = new ArrayList<>();

    @Override
    public MascotaDTO agregarMascota(ClienteDTO clienteDTO) {
        MascotaDTO mascotaDto = new MascotaDTO();
        mascotaDto.setNombre(clienteDTO.getNombre());
        mascotaDto.setRaza(clienteDTO.getApellido());
        mascotaList.add(mascotaDto);
        return mascotaDto;
    }

    @Override
    public MascotaDTO obtenerMascota(String nombre) {
        MascotaDTO mascotaEncontrada = mascotaList.stream()
                .filter(mascotaDTO -> mascotaDTO.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontro una mascota con ese nombre"));
        return mascotaEncontrada;
    }


}
