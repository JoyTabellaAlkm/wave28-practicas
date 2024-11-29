package com.example.Ejercicio_persona;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){}
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni= dni;
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni= dni;
        this.peso = peso;
        this.altura=altura;
    }

    public int  calcularIMC(){
        double imc = this.peso/(Math.pow(this.altura,2));
        String mensaje = "El indice de masa corporal indica que tienes es: ";
        if (imc < 20) {
            System.out.println(mensaje + " bajo peso.");
            return -1;
        }else if(imc >= 20 && imc <= 25){
            System.out.println(mensaje + " peso saludable.");
            return 0;
        }else
            System.out.println(mensaje + " sobrepeso.");
            return 1;
    }

    public boolean esMayorDeEdad(){
        if(this.edad>=18)
            System.out.println("La persona es mayor de edad");
        else System.out.println("La persona es menor de edad");
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
