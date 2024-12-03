package com.mercadolibre;

public class Main {
    public static void main(String[] args) {
        Perro firulais = new Perro("Firulais");
        Vaca vaquita = new Vaca("Estrella");

        Animal animal = firulais;
        animal.emitirSonido();
        animal = vaquita;
        animal.emitirSonido();

        Carnivoro carnivoro = firulais;
        carnivoro.comerCarne();

        Herviboro herviboro = vaquita;
        herviboro.comerHierba();

        comerAnimal(firulais);
        comerAnimal(vaquita);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        } else {
            throw new IllegalArgumentException("El animal suministrado no es conocido.");
        }
    }
}
