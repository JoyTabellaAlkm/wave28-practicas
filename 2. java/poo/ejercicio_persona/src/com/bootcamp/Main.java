package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Persona persona_sin_atributos = new Persona();
        Persona persona_atributos_parcial = new Persona("Nico",25,"41705255");
        Persona persona_atributos_todos = new Persona("NicoDias",25,"41705255",89.7,1.79);
        //Persona persona_error = new Persona("Nico",25,);

        System.out.println(persona_atributos_todos.toString());

        if(persona_atributos_todos.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        switch (persona_atributos_todos.cacularIMC()) {
            case -1:
                System.out.println("La persona esta en situacion de bajo peso");
                break;
            case 0:
                System.out.println("La persona esta en situacion de peso saludable");
                break;
            case 1:
                System.out.println("La persona esta en situacion de sobrepeso");
                break;
        }

    }
}