package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {
    @InjectMocks
    CalculateService service;

    @Test
    @DisplayName("01 - Calcular precio de la vivienda")
    void calculatePrecio() {
        //arrange
        HouseDTO house = crearCasa();

        //act
        Integer obtenidoPrecio= service.calculate(house).getPrice();

        //assert
        //20* 9*30= 59 * 800= 47200
        assertEquals(47200, obtenidoPrecio);
    }

    @Test
    @DisplayName("02- Habitacion con mayor dimension ")
    void devolverHabiltacionConMayoresDimensiones(){
        //arrange
        HouseDTO house = crearCasa();

        //act
        RoomDTO habitacion= service.calculate(house).getBiggest();

        //assert
        assertEquals("Dormitorio", habitacion.getName());

    }

    @Test
    @DisplayName("03- metros cuadrados calculados ")
    void devolverMetrosCuadradosHabitacion(){
        //arrange
        HouseDTO house = crearCasa();
        //act
        Integer metrosCuadrados=  service.calculate(house).getSquareFeet();
        //assert
        //20* 9*30= 59
        assertEquals(59,metrosCuadrados);
    }

    private HouseDTO crearCasa() {
        RoomDTO room1 = new RoomDTO("Cocina", 5, 4);  // 20
        RoomDTO room2 = new RoomDTO("Baño", 3, 3);    // 9
        RoomDTO room3 = new RoomDTO("Dormitorio", 6, 5); // 30
        List<RoomDTO> roomList = List.of(room1, room2, room3);

        HouseDTO house = new HouseDTO();
        house.setName("Casa 1");
        house.setRooms(roomList);
        house.setAddress("Av. Siempre Viva 234");

        return house;
    }


}