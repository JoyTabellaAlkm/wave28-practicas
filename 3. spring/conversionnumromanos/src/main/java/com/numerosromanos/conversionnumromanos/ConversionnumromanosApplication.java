package com.numerosromanos.conversionnumromanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*En este contexto se requiere desarrollar una API para convertir un número decimal a
un número romano. Algunos casos de prueba:
1 → I
2 → II
3 → III
4 → IV
5 → V
7 → VII
10 → X
13 → XIII
50 → L
100 → C
500 → D
1000 → M
*/
@SpringBootApplication
public class ConversionnumromanosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionnumromanosApplication.class, args);
	}

}
