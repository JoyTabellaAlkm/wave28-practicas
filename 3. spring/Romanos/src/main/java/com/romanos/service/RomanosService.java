package com.romanos.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RomanosService {

    private final static Map <Integer, String> numerosRomanos = new HashMap<>();
    static {
        numerosRomanos.put(1, "|");
        numerosRomanos.put(4, "|V");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(9, "|X");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(40, "XL");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(90, "XC");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(400, "CD");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(900, "CM");
        numerosRomanos.put(1000, "M");
    }

    public static String convertirANumeroRomano(int number){

        StringBuilder response = new StringBuilder();
        while (number > 0){
            int newNumber = 0;
            if (number >= 1000){
                newNumber = 1000;
            }
            else if (number >= 900){
                newNumber = 900;
            }
            else if (number >= 500){
                newNumber = 500;
            }
            else if (number >= 400){
                newNumber = 400;
            }
            else if (number >= 100){
                newNumber = 100;
            }
            else if (number >= 90){
                newNumber = 90;
            }
            else if (number >= 50){
                newNumber = 50;
            }
            else if (number >= 40){
                newNumber = 40;
            }
            else if (number >= 10){
                newNumber = 10;
            }
            else if (number >= 9){
                newNumber = 9;
            }
            else if (number >= 5){
                newNumber = 5;
            }
            else if (number >= 4){
                newNumber = 4;
            }
            else {
                newNumber = 1;
            }

            number -= newNumber;
            response.append(numerosRomanos.get(newNumber));
        }

        return response.toString();
    }
}