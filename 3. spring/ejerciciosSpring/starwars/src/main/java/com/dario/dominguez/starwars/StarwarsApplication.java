package com.dario.dominguez.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarwarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsApplication.class, args);
    }


    private int convertirAlturaAEntero(String alturaStr) {
        if (alturaStr == null || alturaStr.isEmpty()) {
            return -1;  // Si la altura es null o vacía, devolvemos -1
        }

        if (alturaStr.equalsIgnoreCase("NA")) {
            return -1;
        }

        try {
            double alturaDecimal = Double.parseDouble(alturaStr);
            return (int) Math.round(alturaDecimal);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
