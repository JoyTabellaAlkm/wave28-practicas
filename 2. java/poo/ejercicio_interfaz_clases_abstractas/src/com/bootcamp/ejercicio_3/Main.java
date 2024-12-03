package com.bootcamp.ejercicio_3;

import com.bootcamp.ejercicio_2.classes.Documento;
import com.bootcamp.ejercicio_3.classes.Animal;
import com.bootcamp.ejercicio_3.classes.Gato;
import com.bootcamp.ejercicio_3.classes.Perro;
import com.bootcamp.ejercicio_3.classes.Vaca;

public class Main {
    public static void main(String[] args) {

        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

}