package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaCon3Parametros = new Persona("Pilar", 29, "123456780");
        Persona personaCompleta = new Persona("David", 29, "987654321", 65.5, 1.70);
        Persona personaCompleta2 = new Persona("Lara", 17, "123", 180.2, 1.0);

//       Persona personaEjemplo = new Persona("Nuria", 23);  //NO ES POSIBLE, TIRA ERROR

        System.out.println("Personas:");
        System.out.println(personaSinParametros.toString());
        System.out.println(personaCon3Parametros.toString());
        System.out.println(personaCompleta.toString());

        System.out.println("Calculo ICM:" + personaCompleta.calcularIMC(personaCompleta.getPeso(), personaCompleta.getAltura()));

        if (personaCompleta.esMayorDeEdad(personaCompleta.getEdad())) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        System.out.println("Calculo ICM:" + personaCompleta2.calcularIMC(personaCompleta2.getPeso(), personaCompleta2.getAltura()));

        if (personaCompleta2.esMayorDeEdad(personaCompleta2.getEdad())) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }
}