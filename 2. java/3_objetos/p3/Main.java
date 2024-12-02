package com.company;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("David", 28, "123456");
        Persona persona3 = new Persona("Pepe", 28, "789123", 80.1,1.70);

        // Error de instancia por lo que no existe el un constructor con 2 parametros.
        //Persona persona4 = new Persona("Carlos", 20);

        //Ejercicio 6
        System.out.println(persona3.toString());
    }
}
