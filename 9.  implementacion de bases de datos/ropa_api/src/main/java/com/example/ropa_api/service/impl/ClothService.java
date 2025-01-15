package com.example.ropa_api.service.impl;

import com.example.ropa_api.dto.RequestClothDto;
import com.example.ropa_api.dto.ResponseDto;
import com.example.ropa_api.model.Cloth;
import com.example.ropa_api.model.Sale;
import com.example.ropa_api.repository.ClothRepository;
import com.example.ropa_api.repository.SaleRepository;
import com.example.ropa_api.service.IClothService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService implements IClothService {
    @Autowired
    private ClothRepository clothRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Cloth create(RequestClothDto requestTestCaseDto) {
        ModelMapper modelMapper = new ModelMapper();
        return clothRepository.save(modelMapper.map(requestTestCaseDto, Cloth.class));
    }

    @Override
    public List<Cloth> getAll(String name, Long number) {
        if (name != null && number != null) {
            throw new RuntimeException("Solo se permite un parámetro a la vez: name o number.");
        }

        if (name != null) {
            return clothRepository.findByNameContainingIgnoreCase(name);
        }

        if (number != null) {
            Sale sale = saleRepository.findById(number).orElseThrow(() -> new RuntimeException("No se encontro la venta"));
            return clothRepository.findBySales(List.of(sale));
        }

        return clothRepository.findAll();
    }

    @Override
    public Cloth show(Long id) {
        return clothRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la ropa"));
    }

    @Override
    public Cloth update(Long id, RequestClothDto requestClothDto) {
        ModelMapper modelMapper = new ModelMapper();
        clothRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cloth"));

        Cloth cloth = modelMapper.map(requestClothDto, Cloth.class);
        cloth.setId(id);

        return clothRepository.save(cloth);
    }

    @Override
    public ResponseDto delete(Long id) {
        clothRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cloth"));
        clothRepository.deleteById(id);
        return new ResponseDto("Se elimino la ropa con ID: " + id);
    }

    @Override
    public List<Cloth> getAllBySize(String size) {
        return clothRepository.findAllBySize(size);
    }
}
