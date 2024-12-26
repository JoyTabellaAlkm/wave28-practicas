package com.mercadolibre.calculadorametroscuadrados.unitTest.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTest {
    CalculateService service = new CalculateService();
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
    public void calculateHouseResponseDTO() {
        // arrange
        HouseDTO houseDTO = new HouseDTO(
                "Casa de Verano",
                "Calle Ficticia 123",
                hambientes
        );

        // act
        HouseResponseDTO houseResponse = service.calculate(houseDTO);

        // assert
        Assertions.assertEquals(houseResponseDTO, houseResponse);
    }

}
