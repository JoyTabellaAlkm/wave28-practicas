package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.entity.Joya;
import com.example.joyerialasperlas.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaServiceImpl implements IJoyaService{

    @Autowired
    JoyaRepository joyaRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional (readOnly = true)
    public List<JoyaDto> getJoyas() {
        List<Joya> joyaList = joyaRepository.findAll();
        List<JoyaDto> joyaDtos = joyaList
                .stream()
                .filter(j->j.getVentaONo())
                .map(j->mapper.map(j,JoyaDto.class))
                .toList();
        return joyaDtos;
    }

    @Override
    @Transactional
    public long saveJoya(JoyaDto joyaDto) {
        Joya joyaToSave = mapper.map(joyaDto,Joya.class);
        joyaRepository.save(joyaToSave);
        return joyaToSave.getNroIdentificatorio();
    }

    @Override
    @Transactional
    public long deleteJoya(long nroIdentificatorio) {
        joyaRepository.deleteById(nroIdentificatorio);
        return nroIdentificatorio;
    }

    @Override
    @Transactional
    public JoyaDto findJoya(long nroIdentificatorio) {
        Optional<Joya> foundJoya = joyaRepository.findById(nroIdentificatorio);
        if (foundJoya.isEmpty()){
            return null;
        }
        JoyaDto foundJoyaDto = mapper.map(foundJoya,JoyaDto.class);
        return foundJoyaDto;
    }

    @Override
    public long logicDeleteJoya(long nroIdentificatorio) {
        Optional<Joya> joyaToLogicDelete = joyaRepository.findById(nroIdentificatorio);
        joyaToLogicDelete.get().setVentaONo(false);
        joyaRepository.save(joyaToLogicDelete.get());
        return nroIdentificatorio;
    }

    @Override
    public JoyaDto updateJoya(long nroIdentificatorio, JoyaDto joyaDto) {
        Joya joyaToSave = mapper.map(joyaDto,Joya.class);
        joyaToSave.setNroIdentificatorio(nroIdentificatorio);
        joyaRepository.save(joyaToSave);
        return joyaDto;
    }
}
