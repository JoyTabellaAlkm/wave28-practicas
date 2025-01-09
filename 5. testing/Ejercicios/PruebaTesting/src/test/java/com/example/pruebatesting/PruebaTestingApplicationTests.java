package com.example.pruebatesting;

import com.example.pruebatesting.service.IMatematicaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PruebaTestingApplicationTests {

    @Autowired
    IMatematicaService matematicaService;
    @Test
    void sumarNumeros(){
        //Arrange
        int a = 1, b = 1, esperado = 2;

        //Act
        int obtenido = matematicaService.sumar(a,b);

        //Assert
        Assertions.assertEquals(esperado,obtenido);
    }

    void contextLoads() {
    }


}
