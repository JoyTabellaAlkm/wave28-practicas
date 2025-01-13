package com.lasPerlas.jewerly.service;

import com.lasPerlas.jewerly.dto.request.NewJewelDTO;
import com.lasPerlas.jewerly.dto.response.JewelDTO;
import com.lasPerlas.jewerly.model.Jewel;
import com.lasPerlas.jewerly.repository.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lasPerlas.jewerly.util.MapperJewel.*;

@Service
public class JewelServiceImpl implements IJewelService{

    @Autowired
    IJewelRepository jewelRepository;

    @Override
    public Long createJewel(NewJewelDTO jewel) {
        Jewel newJewel = jewelRepository.save(toEntity(jewel));
        return newJewel.getNroIdentificatorio();
    }

    @Override
    public List<JewelDTO> getAllJewels() {

        List<JewelDTO> jewelsList = jewelRepository.findAll().stream()
                    .filter(jewel -> jewel.isVentaONo())
                    .toList()
                .stream().map(j -> toDTO(j))
                .toList();

        return jewelsList;
    }

    @Override
    public JewelDTO getById(Long id) {
        Jewel jewel = jewelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe una joya con el id: "+ id));
        return toDTO(jewel);
    }

    @Override
    public JewelDTO deleteById(Long id) {
        Jewel jewel = jewelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe una joya con el id: "+ id));
        jewel.setVentaONo(false);
        jewelRepository.save(jewel);
        return toDTO(jewel);
    }

    @Override
    public JewelDTO update(NewJewelDTO jewel, Long id) {
        Jewel jewelToModify = jewelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe una joya con el id: "+ id));

        Jewel modifyJewel = toEntity(jewel);
        modifyJewel.setNroIdentificatorio(jewelToModify.getNroIdentificatorio());

        jewelRepository.save(modifyJewel);

        return toDTO(modifyJewel);
    }
}
