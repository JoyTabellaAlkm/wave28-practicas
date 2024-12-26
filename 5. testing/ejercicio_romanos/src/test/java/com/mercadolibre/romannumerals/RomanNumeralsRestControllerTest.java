package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsRestControllerTest {
    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @Test
    void testOneToRoman() throws Exception {
        Assertions.assertEquals("I", controller.toRoman(1), "The Roman numeral for 1 should be I");
    }

    @Test
    void testThreeToRoman() throws Exception {
        Assertions.assertEquals("III", controller.toRoman(3), "The Roman numeral for 3 should be III");
    }

    @Test
    void testFiveToRoman() throws Exception {
        Assertions.assertEquals("V", controller.toRoman(5), "The Roman numeral for 5 should be V");
    }

    @Test
    void testSevenToRoman() throws Exception {
        Assertions.assertEquals("VII", controller.toRoman(7), "The Roman numeral for 7 should be VII");
    }

    @Test
    void testTenToRoman() throws Exception {
        Assertions.assertEquals("X", controller.toRoman(10), "The Roman numeral for 10 should be X");
    }

    @Test
    void testFiftyToRoman() throws Exception {
        Assertions.assertEquals("L", controller.toRoman(50), "The Roman numeral for 50 should be L");
    }
}
