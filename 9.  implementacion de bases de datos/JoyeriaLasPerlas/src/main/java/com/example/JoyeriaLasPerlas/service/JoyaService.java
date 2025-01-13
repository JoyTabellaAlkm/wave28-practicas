package com.example.JoyeriaLasPerlas.service;

import com.example.JoyeriaLasPerlas.exception.NotFoundException;
import com.example.JoyeriaLasPerlas.dtos.JoyaDto;
import com.example.JoyeriaLasPerlas.dtos.RespuestaDto;
import com.example.JoyeriaLasPerlas.model.Joya;
import com.example.JoyeriaLasPerlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService{

    IJoyaRepository iJoyaRepository;

    ModelMapper modelMapper = new ModelMapper();

    public JoyaService(IJoyaRepository iJoyaRepository) {
        this.iJoyaRepository = iJoyaRepository;
    }

    @Override
    public RespuestaDto agregarJoya(JoyaDto joyaDto) {
        Joya joya = new Joya();
        modelMapper.map(joyaDto, joya);
        Joya joyaGuardada =  iJoyaRepository.save(joya);
        RespuestaDto respuestaDto = new RespuestaDto("Joya guardada correctamente con nro " + joyaGuardada.getId());
        return respuestaDto;
    }

    @Override
    public RespuestaDto actualizarJoya(Integer id_actualizar, JoyaDto joyaDto) {
        Optional<Joya> joyaExistente = iJoyaRepository.findById(id_actualizar);
        if(joyaExistente.isPresent()){
            Joya joya = joyaExistente.get();
            modelMapper.map(joyaDto, joya);
            iJoyaRepository.save(joya);
            return new RespuestaDto("Joya actualizada correctamente");
        }else{
            throw new NotFoundException("Joya no encontrada con ID " + id_actualizar);
        }
    }

    @Override
    public List<JoyaDto> listarJoyas() {
        return iJoyaRepository.findAll()
                .stream()
                .filter(joya -> joya.isVentaONo() != false)
                .map(joya -> modelMapper.map(joya, JoyaDto.class))
                .toList();
    }

    @Override
    public RespuestaDto eliminarJoya(Integer id) {
        Optional<Joya> joyaExistente = iJoyaRepository.findById(id);
        if(joyaExistente.isPresent()){
            iJoyaRepository.deleteById(id);
            return new RespuestaDto("Joya eliminada correctamente");
        }else{
            throw new NotFoundException("Joya no encontrada con ID " + id);
        }

    }
}
