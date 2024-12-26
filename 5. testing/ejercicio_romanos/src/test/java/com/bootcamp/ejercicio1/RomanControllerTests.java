package com.bootcamp.ejercicio1;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanControllerTests {

    @Autowired
    RomanController romanController;

    @ParameterizedTest
    @CsvSource(value = {"1:I", "3:III", "5:V", "7:VII", "10:X", "50:L", "1999:MCMXCIX","3724:MMMDCCXXIV"}, delimiter =  ':')
    void romanConverterTest(Integer input, String expected) {
        String result = romanController.toRoman(input);
        Assertions.assertEquals(expected, result);
    }

}
