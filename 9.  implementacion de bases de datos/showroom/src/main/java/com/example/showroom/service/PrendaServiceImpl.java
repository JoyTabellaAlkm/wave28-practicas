package com.example.showroom.service;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.PrendaWithCodeDto;
import com.example.showroom.model.Prenda;
import com.example.showroom.repository.IPrendaRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PrendaServiceImpl implements IPrendaService {

    private final IPrendaRepository prendaRepository;
    private final ModelMapper modelMapper;

    public PrendaServiceImpl(IPrendaRepository prendaRepository, ModelMapper modelMapper){
        this.prendaRepository = prendaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PrendaWithCodeDto createPrenda(PrendaDto prendaDto){
        Prenda prenda = modelMapper.map(prendaDto, Prenda.class);
        return modelMapper.map(prendaRepository.save(prenda), PrendaWithCodeDto.class);
    }

    @Override
    public List<PrendaWithCodeDto> getAllPrendas() {
        List<Prenda> prendas = prendaRepository.findAll();
        return prendas.stream()
                .map(p -> modelMapper.map(p, PrendaWithCodeDto.class))
                .toList();
    }

    @Override
    public PrendaDto getPrendaByCodigo(Long codigo){
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        if(prenda.isEmpty()){
            throw new NoSuchElementException(); // TO DO: Aplicar exception
        }

        return modelMapper.map(prenda.get(), PrendaDto.class);
    }

    @Override
    public PrendaDto updatePrenda(PrendaDto prenda, Long codigo) {
        getPrendaByCodigo(codigo);

        Prenda toUpdate = modelMapper.map(prenda, Prenda.class);
        toUpdate.setCodigo(codigo);
        return modelMapper.map(prendaRepository.save(toUpdate), PrendaDto.class);
    }

    @Override
    public MessageDto deletePrenda(Long codigo) {
        getPrendaByCodigo(codigo);
        prendaRepository.deleteById(codigo);
        return new MessageDto("La prenda con el código " + codigo + " ha sido eliminada correctamente");
    }

    @Override
    public List<PrendaWithCodeDto> getPrendasByTalla(String talla){
        List<Prenda> prendasPorTalla = prendaRepository.findByTallaIgnoreCase(talla);
        return prendasPorTalla.stream()
                .map(p -> modelMapper.map(p, PrendaWithCodeDto.class))
                .toList();
    }

    @Override
    public List<PrendaWithCodeDto> getPrendasByName(String name){
        List<Prenda> prendasPorName = prendaRepository.findByNombreLikeIgnoreCase(name);
        return prendasPorName.stream()
                .map(p -> modelMapper.map(p, PrendaWithCodeDto.class))
                .toList();
    }

}
