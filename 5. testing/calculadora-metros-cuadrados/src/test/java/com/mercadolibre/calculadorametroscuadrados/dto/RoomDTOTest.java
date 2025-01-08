package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomDTOTest {
    @Test
    public void getSquareFeetPerformsCalculationCorrectly(){
        Integer expectedSquareFeet = 3*2;
        RoomDTO room = new RoomDTO("Living", 3, 2);

        Integer squareFeet = room.getSquareFeet();

        Assertions.assertEquals(expectedSquareFeet, squareFeet);
    }
}
