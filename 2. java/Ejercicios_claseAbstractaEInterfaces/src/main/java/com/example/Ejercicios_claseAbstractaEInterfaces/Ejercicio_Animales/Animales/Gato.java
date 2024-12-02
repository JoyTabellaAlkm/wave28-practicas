package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato(){}

    @Override
    public String emitirSonido() {
        return "miau";
    }

    @Override
    public String comerCarne() {
        return "Gato comiendo atun";
    }
}
