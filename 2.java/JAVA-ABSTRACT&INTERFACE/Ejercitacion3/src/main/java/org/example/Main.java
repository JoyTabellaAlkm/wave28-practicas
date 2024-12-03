package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sonido:");
        Animal perro = new Perro();
        perro.emitirSonido();
        Animal gato = new Gato();
        gato.emitirSonido();
        Animal vaca = new Vaca();
        vaca.emitirSonido();


        System.out.println("Comiendo:");
        gato.comerAnimal();
        perro.comerAnimal();
        vaca.comerAnimal();




    }
}