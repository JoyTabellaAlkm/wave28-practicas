package com.mercadolibre;

public class Persona {

    String dni;
    String nombre;
    int edad;
    // Peso en kilogramos
    double peso;
    // Altura en metros
    double altura;

    public Persona() {
    }

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String dni, String nombre, int edad, double peso, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = (peso / (Math.pow(altura, 2)));
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

}
