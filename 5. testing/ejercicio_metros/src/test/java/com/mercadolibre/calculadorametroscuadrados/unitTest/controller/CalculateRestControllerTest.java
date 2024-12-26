package com.mercadolibre.calculadorametroscuadrados.unitTest.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    RoomDTO salaDeEstar = new RoomDTO(
            "Sala de Estar",
            5,
            7
    );
    RoomDTO dormitorio = new RoomDTO(
            "Dormitorio",
            4,
            4
    );
    RoomDTO cocina = new RoomDTO(
            "Cocina",
            4,
            6
    );
    List<RoomDTO> hambientes = List.of(
            salaDeEstar, cocina, dormitorio
    );

    HouseResponseDTO houseResponseDTO = new HouseResponseDTO(
            "Casa de Verano",
            "Calle Ficticia 123",
            hambientes,
            75,
            60000,
            salaDeEstar

    );

    @Test
    public void findCharacter() {
        // arrange
        HouseDTO houseDTO = new HouseDTO(
                "Casa de Verano",
                "Calle Ficticia 123",
                hambientes
        );

        // act
        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);
        HouseResponseDTO houseResponse = controller.calculate(houseDTO);

        // assert
        verify(service, atLeastOnce()).calculate(houseDTO);
        Assertions.assertEquals(houseResponseDTO, houseResponse);
    }
}
