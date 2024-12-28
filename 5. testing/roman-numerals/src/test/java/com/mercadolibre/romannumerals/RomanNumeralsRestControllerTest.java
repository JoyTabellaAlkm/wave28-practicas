package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController romanNumeralsRestController;

    @BeforeEach
    void setUp() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    @DisplayName("Should return \"I\" when number 1 is passed.")
    void shouldReturnIWhen1IsPassed() {
        // Arrange
        int number = 1;
        String expected = "I";
        // Act
        String obtained = romanNumeralsRestController.toRoman(number);
        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Should return \"III\" when number 3 is passed.")
    void shouldReturnIIIWhen3IsPassed() {
        // Arrange
        int number = 3;
        String expected = "III";
        // Act
        String obtained = romanNumeralsRestController.toRoman(number);
        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Should return \"V\" when number 5 is passed.")
    void shouldReturnVWhen5IsPassed() {
        // Arrange
        int number = 5;
        String expected = "V";
        // Act
        String obtained = romanNumeralsRestController.toRoman(number);
        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Should return \"VII\" when number 7 is passed.")
    void shouldReturnVIIWhen7IsPassed() {
        // Arrange
        int number = 7;
        String expected = "VII";
        // Act
        String obtained = romanNumeralsRestController.toRoman(number);
        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Should return \"X\" when number 10 is passed.")
    void shouldReturnXWhen10IsPassed() {
        // Arrange
        int number = 10;
        String expected = "X";
        // Act
        String obtained = romanNumeralsRestController.toRoman(number);
        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Should return \"L\" when number 50 is passed.")
    void shouldReturnLWhen50IsPassed() {
        // Arrange
        int number = 50;
        String expected = "L";
        // Act
        String obtained = romanNumeralsRestController.toRoman(number);
        // Assert
        assertEquals(expected, obtained);
    }
}