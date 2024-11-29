package com.mercadolibre;

public class Main {
    public static void main(String[] args) {
        // No es posible crear un objeto de tipo persona solo con el nombre y la edad.

        Persona persona = new Persona();
        Persona persona2 = new Persona("12345678", "Juan", 30);
        Persona persona3 = new Persona("12345679", "Pedro", 25, 80, 1.80);

        int imc = persona3.calcularIMC();
        boolean mayorDeEdad = persona3.esMayorDeEdad();

        System.out.println("La persona " + persona3.nombre + (imc == -1 ? " está por debajo del peso ideal"
                : imc == 0 ? " está en el peso ideal" : " está por encima del peso ideal"));
        System.out.println(
                "La persona " + persona3.nombre + (mayorDeEdad ? " es mayor de edad" : " no es mayor de edad"));
        System.out.println(persona3);
    }
}