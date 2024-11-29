package com.company;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Noel",25,"1111111");
        Persona persona2 = new Persona("Simon",22,"1111111",70, 1.70);
        Persona persona3 = new Persona();
        //Persona persona1 = new Persona("Noel",3);
        //no es posible este objeto ya que el constructor con estos parametros no existe

        System.out.println(persona2);

        int imc = persona2.calcularIMC();
        switch (imc) {
            case 1:
                System.out.println("Usted tiene bajo peso.");
                break;
            case 0:
                System.out.println("Usted está bien de peso.");
                break;
            case -1:
                System.out.println("Usted tiene sobrepeso.");
                break;
        }

        if (persona2.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }
    }
}
