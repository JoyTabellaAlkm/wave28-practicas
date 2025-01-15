package com.ar.mercadolibre.joyerialasperlas.service;

import com.ar.mercadolibre.joyerialasperlas.dto.CreateMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.DeleteMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.JewelryDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.UpdateMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.entity.Jewelry;
import com.ar.mercadolibre.joyerialasperlas.exception.NotFoundException;
import com.ar.mercadolibre.joyerialasperlas.repository.IJewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryServiceImpl implements IJewelryService {

    private final IJewelryRepository jewelryRepository;
    private final ModelMapper modelMapper;

    public JewelryServiceImpl(IJewelryRepository jewelryRepository, ModelMapper modelMapper) {
        this.jewelryRepository = jewelryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateMessageDTO create(JewelryDTO jewelryDTO) {
        Jewelry jewelry = modelMapper.map(jewelryDTO, Jewelry.class);
        return new CreateMessageDTO(jewelryRepository.save(jewelry).getJewelryId(), "The jewelry has been created");
    }

    @Override
    public List<JewelryDTO> getAll() {
        List<Jewelry> jewelryList = jewelryRepository.findAll();
        if(jewelryList.isEmpty()) {
            throw new NotFoundException("No Jewelry has been found");
        }

        return jewelryList.stream().map(jewelry -> modelMapper.map(jewelry, JewelryDTO.class)).toList();
    }

    @Override
    public DeleteMessageDTO delete(Long id) {
        Jewelry jewelryToDelete = validateJewelryId(id);
        jewelryToDelete.setIsOnSale(false);
        jewelryRepository.save(jewelryToDelete);

        return new DeleteMessageDTO(id, "The jewelry has been erased");
    }

    @Override
    public UpdateMessageDTO update(Long idToModify, JewelryDTO jewelryDTO) {
        validateJewelryId(idToModify);
        jewelryDTO.setJewelryId(idToModify);
        Jewelry jewelryToUpdate = modelMapper.map(jewelryDTO, Jewelry.class);

        JewelryDTO updatedJewelry = modelMapper.map(jewelryRepository.save(jewelryToUpdate), JewelryDTO.class);

        return new UpdateMessageDTO(updatedJewelry, "The jewelry has been updated");
    }

    private Jewelry validateJewelryId(Long id) {
        Optional<Jewelry> jewelry = jewelryRepository.findById(id);
        if(jewelry.isEmpty()) {
            throw new NotFoundException("No jewelry found with the provided id");
        }

        return jewelry.get();
    }
}
