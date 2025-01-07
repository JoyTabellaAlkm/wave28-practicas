package com.example.starwars.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.*;
import com.example.starwars.service.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class FindControllerTest {
    @org.mockito.Mock
    FindService findService;

    @org.mockito.InjectMocks
    FindController controller;

    @Test
    void find() {
        //arrenge
         String param="luke";
        //act

        java.util.List<com.example.starwars.dto.CharacterDTO> chracterList=
                controller.find(param);


        //assert
        verify(findService,atLeastOnce()).find(param);

    }
}