package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @Mock
    private HouseDTO house;
    @Mock
    private RoomDTO room;

    @Test
    public void calculatePriceOf10x10mHouseReturnsCorrectPrice(){
        CalculateService service = new CalculateService();
        Integer expectedPrice = 10*10*800;
        when(room.getSquareFeet()).thenReturn(100);
        when(house.getRooms()).thenReturn(List.of(room));

        HouseResponseDTO response = service.calculate(house);

        Assertions.assertEquals(expectedPrice, response.getPrice());
    }
}
