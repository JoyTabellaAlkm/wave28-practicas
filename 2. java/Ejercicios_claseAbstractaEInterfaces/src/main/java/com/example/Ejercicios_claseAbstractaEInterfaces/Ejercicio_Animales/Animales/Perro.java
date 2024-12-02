package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales.Animal;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {

    public Perro() {
    }

    @Override
    public String emitirSonido() {
        return "guau";
    }

    @Override
    public String comerCarne() {
        return "Perro comiendo carne";
    }
}
