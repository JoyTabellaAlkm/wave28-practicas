package com.example.demo.service;

import com.example.demo.dto.request.ClienteDTO;
import com.example.demo.dto.request.MascotaDTO;
import com.example.demo.dto.response.ClienteDTOResponse;
import com.example.demo.dto.response.MascotaDTOResponse;
import com.example.demo.dto.response.RespuestaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ICliente {

    List<ClienteDTO> clienteList = new ArrayList<>();

    @Override
    public RespuestaDTO agregarPersona(ClienteDTO clienteDto) {
        List<MascotaDTO> mascotasList = clienteDto.getMascotasList();
        ClienteDTO clienteNuevo = new ClienteDTO();
        clienteNuevo.setNombre(clienteDto.getNombre());
        clienteNuevo.setApellido(clienteDto.getApellido());
        clienteNuevo.setMascotasList(mascotasList);


        clienteList.add(clienteNuevo);
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setMensaje("Persona agregada");
        return respuestaDTO;
    }

    @Override
    public ClienteDTO obtenerPersona(String nombre) {
        ClienteDTO personaEncontrada = clienteList.stream()
                .filter(clienteDTO -> clienteDTO.getNombre().equals(nombre))
                .findFirst().orElseThrow(() -> new RuntimeException("No se encontro una persona con ese nombre"));

        return personaEncontrada;
    }

    @Override
    public List<ClienteDTOResponse> obtenerPersonas() {
        List<ClienteDTOResponse> clienteListResponse = new ArrayList<>();

        clienteList.forEach(persona -> {
            ClienteDTOResponse clienteDTOResponse = new ClienteDTOResponse();
            clienteDTOResponse.setNombreCompleto(persona.getNombre() + " " + persona.getApellido());

            // Convertir mascotas si es necesario
            List<MascotaDTOResponse> mascotasListResponse = persona.getMascotasList().stream()
                    .map(mascota -> {
                        MascotaDTOResponse mascotaDTOResponse = new MascotaDTOResponse();
                        mascotaDTOResponse.setNombre(mascota.getNombre());
                        mascotaDTOResponse.setRaza(mascota.getRaza());
                        return mascotaDTOResponse;
                    })
                    .toList();

            clienteDTOResponse.setMascotasList(mascotasListResponse);

            // Agregar a la lista de respuesta
            clienteListResponse.add(clienteDTOResponse);
        });

        return clienteListResponse;
    }

    @Override
    public ClienteDTO actualizarPersona(String nombre, ClienteDTO clienteDto) {
        ClienteDTO personaAActualizar = obtenerPersona(nombre);
        if (personaAActualizar != null) {
            personaAActualizar.setNombre(clienteDto.getNombre());
            personaAActualizar.setApellido(clienteDto.getApellido());
            personaAActualizar.setMascotasList(clienteDto.getMascotasList());
        } else {
            throw new RuntimeException("No se encontro una persona con ese nombre");
        }

        return personaAActualizar;
    }

    @Override
    public RespuestaDTO eliminarPersona(String nombre) {
        ClienteDTO personaAEliminar = obtenerPersona(nombre);

        if (personaAEliminar != null) {
            clienteList.remove(personaAEliminar);
        } else {
            throw new RuntimeException("No se encontro una persona con ese nombre");
        }

        return new RespuestaDTO("Persona eliminada");
    }
}
