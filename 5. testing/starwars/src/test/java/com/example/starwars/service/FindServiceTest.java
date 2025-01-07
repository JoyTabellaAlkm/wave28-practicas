package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    private CharacterDTO lukeDTO;
    private CharacterDTO darthVader;
    private CharacterDTO darthMaul;

    private List<CharacterDTO> characterDTOList;

    @BeforeEach
    void setUp() {
        characterDTOList = new ArrayList<>();
        initializeLuke();
        initializeDarthVader();
        initializeDarthMaul();
    }

    @Test
    @DisplayName("01 - find a character")
    void find() {

        //arrange
        String param= "luke";
        List<CharacterDTO> characterDTOList= List.of(new CharacterDTO());
        when(characterRepository.findAllByNameContains(param)).thenReturn(characterDTOList);
        //act
        List<CharacterDTO> characterDTOS = findService.find(param);

        //assert
        assertEquals(1, characterDTOS.size());

    }






    private void initializeLuke() {
        lukeDTO = new CharacterDTO();
        lukeDTO.setName("Luke Skywalker");
        lukeDTO.setHair_color("blond");
        lukeDTO.setSkin_color("fair");
        lukeDTO.setEye_color("blue");
        lukeDTO.setBirth_year("19BBY");
        lukeDTO.setGender("male");
        lukeDTO.setHomeworld("Tatooine");
        lukeDTO.setSpecies("Human");
        lukeDTO.setHeight(172);
        lukeDTO.setMass(77);
        characterDTOList.add(lukeDTO);
    }

    private void initializeDarthVader() {
        darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        characterDTOList.add(darthVader);
    }

    private void initializeDarthMaul() {
        darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setHair_color("none");
        darthMaul.setSkin_color("red");
        darthMaul.setEye_color("yellow");
        darthMaul.setBirth_year("54BBY");
        darthMaul.setGender("male");
        darthMaul.setHomeworld("Dathomir");
        darthMaul.setSpecies("Zabrak");
        darthMaul.setHeight(175);
        darthMaul.setMass(80);
        characterDTOList.add(darthMaul);
    }








}