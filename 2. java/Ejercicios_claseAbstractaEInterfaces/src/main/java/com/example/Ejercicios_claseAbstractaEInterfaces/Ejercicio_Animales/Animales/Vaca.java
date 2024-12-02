package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales.Animal;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    public Vaca(){}

    @Override
    public String emitirSonido() {
        return "muu";
    }

    @Override
    public String comerHierba() {
        return "Vaca comiendo pasto";
    }
}
