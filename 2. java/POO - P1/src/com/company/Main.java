package com.company;

public class Main {

    public static void main(String[] args) {
	    //region Practica VIDEO P1
        /*Libro libro = new Libro("Harry Potter","J. K. Rowling",20);

        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este libro es de: " + libro.cantidadEjemplares());*/
        //endregion

        //region Ejercicio Practico #1
        /*Automovil automovil = new Automovil();
        Automovil automovil2 = new Automovil("chevrolet","negro",20.56);

        automovil2.mostrarMarcaYColor();*/
        //endregion

        //region Ejercicio en VIVO
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Gabriel", 26, "123");
        Persona persona3 = new Persona("Luciana", 15, "9876", 50, 1.90);

        //Persona persona4 = new Persona("Gabriel", 26);

        int resultado = persona3.calcularIMC();

        if (resultado == -1) {
            System.out.println("Por debajo de 20");
            System.out.println("Bajo peso");
        } else if (resultado == 0) {
            System.out.println("Entre 20 y 25 inclusive");
            System.out.println("Peso saludable");
        } else if (resultado == 1) {
            System.out.println("Mayor de 25");
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Clasificación: Obesidad");
        }
        String edadResultado = persona3.esMayorDeEdad() ? "Mayor de edad" : "Menor de edad";
        System.out.println("La persona es " + edadResultado);
        //endregion


    }
}
