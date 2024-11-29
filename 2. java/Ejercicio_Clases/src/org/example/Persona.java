package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //constructor
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    //EJERCICIO 2

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", DNI: " + dni + ", Peso: " + peso + ", Altura: " + altura;
    }

    public double getPeso() {
        return peso;
    }
    public double getAltura() {
        return altura;
    }
    public int getEdad() {
        return edad;
    }

    public String calcularIMC(double peso, double altura) {
        double pesoCalculable = peso / (altura*altura) ;
        if (pesoCalculable < 20) {
            int valorIMC = -1;
            return valorIMC + " Bajo Peso";
        } else if (pesoCalculable >= 20 && pesoCalculable <= 25) {
            int valorIMC = 0;
            return valorIMC + " Peso Saludable";
        } else {
            int valorIMC = 1;
            return valorIMC + " Sobrepeso";
        }
    }


    public boolean esMayorDeEdad(int edad) {
        if (edad > 18) {
            return true;
        }
        return false;
    }
}
