package com.mercadolibre.calculadorametroscuadrados;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UnitariosTest {

    CalculateService calculateServiceImpl = new CalculateService();

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    RoomDTO roomDTO = new RoomDTO("habitacion 1", 10, 10);
    HouseDTO houseDTO = new HouseDTO("Casa 1", "calle", new ArrayList<>(List.of(new RoomDTO("habitacion 1", 10, 10))));
    HouseResponseDTO esperado = new HouseResponseDTO(houseDTO,100, 80000,roomDTO);
    HouseDTO houseDTO2 = new HouseDTO("Casa 2", "calle 2", new ArrayList<>(List.of(new RoomDTO("habitacion 1", 20, 20))));
    HouseDTO houseDTO3 = new HouseDTO();

    @Test
    public void serviceTest(){
        HouseResponseDTO obtenido = calculateServiceImpl.calculate(houseDTO);

        Assertions.assertEquals(esperado, obtenido);
    }

    @Test
    public void serviceTestBadPath(){
        HouseResponseDTO obtenido = calculateServiceImpl.calculate(houseDTO);

        Assertions.assertNotEquals(houseDTO2, obtenido);
    }

    @Test
    public void serviceTestBadParams(){

        Assertions.assertThrows(NullPointerException.class,
                () -> {calculateServiceImpl.calculate(houseDTO3); });
    }

    @Test
    public void controllerTest(){
        Mockito.when(calculateService.calculate(houseDTO)).thenReturn(esperado);

        HouseResponseDTO obtenido = calculateRestController.calculate(houseDTO);

        Assertions.assertEquals(esperado, obtenido);
    }

}
