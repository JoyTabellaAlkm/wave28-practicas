package com.company;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }


    public int calcularIMC() {
        double imc = this.peso / (Math.pow(this.altura, 2));
        int valor;

        if (imc < 20) {
            valor = -1;
        } else if (imc >= 20 && imc <= 25) {
            valor = 0;
        } else {
            valor = 1;
        }

        return valor;
    }


    public boolean esMayorDeEdad() {
        boolean esMayor = false;

        if (this.edad > 17) {
            esMayor = true;
        }

        return esMayor;
    }

    public String toString() {

        String mensajeIMC = "";
        int imc = this.calcularIMC();
        String esMayor = " , no es mayor de edad.";
        if( imc < 0 ){
            mensajeIMC = "Bajo peso";
        }else if(imc > 0){
            mensajeIMC = "Sobre peso";
        }else{
            mensajeIMC = "Peso saludable";
        }

        if(this.esMayorDeEdad()){
            esMayor= " , es mayor de edad.";
        }

        return "Nombre: " + this.nombre + ", edad: " + this.edad + ", DNI: " + this.dni + " , peso: " + this.peso + ", altura: " + this.altura + ", IMC: " + mensajeIMC + esMayor ;
    }

}
