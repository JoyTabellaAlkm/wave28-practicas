package com.mercadolibre.joyeria_las_perlas.service.imp;

import com.mercadolibre.joyeria_las_perlas.dto.request.JoyaRequestDTO;
import com.mercadolibre.joyeria_las_perlas.dto.response.JoyaDTO;
import com.mercadolibre.joyeria_las_perlas.model.Joya;
import com.mercadolibre.joyeria_las_perlas.repository.JoyaRepository;
import com.mercadolibre.joyeria_las_perlas.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaServiceImp implements com.mercadolibre.joyeria_las_perlas.service.JoyaService {

    private final JoyaRepository joyaRepository;

    public JoyaServiceImp(JoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDTO> getAll() {
        List<Joya> joyasList = joyaRepository.findAll();
        return joyasList.stream().map(joya -> Utils.getModelMapper()
                .map(joya, JoyaDTO.class)
        ).toList();
    }

    @Override
    public JoyaDTO save(JoyaDTO joya) {
        Joya joyaToSave = Utils.getModelMapper().map(joya, Joya.class);
        joyaRepository.save(joyaToSave);
        return joya;
    }

    @Override
    public boolean delete(long id) {
        joyaRepository.deleteById(id);
        JoyaDTO joya = findById(id);
        if (joya == null) return false;
        return true;
    }

    @Override
    public JoyaDTO findById(long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        if(joya.isEmpty()) return null;
        return Utils.getObjectMapper().convertValue(joya, JoyaDTO.class);
    }

    @Override
    public JoyaDTO edit(Long id, JoyaRequestDTO joyaRequestDTO) {
        JoyaDTO response = findById(id);
        if (response == null) return null;
        Joya newJoya = Utils.getModelMapper().map(joyaRequestDTO, Joya.class);
        newJoya.setId(id);
        return Utils.getModelMapper().map(joyaRepository.save(newJoya), JoyaDTO.class);
    }
}
