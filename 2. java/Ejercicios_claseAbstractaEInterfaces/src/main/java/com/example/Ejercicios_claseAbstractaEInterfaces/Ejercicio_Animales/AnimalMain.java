package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales.Animal;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales.Gato;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales.Perro;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Animales.Animales.Vaca;

public class AnimalMain {

    public static void main(String[] args){
        Perro perro = new Perro();
        System.out.println(perro.emitirSonido());
        System.out.println(perro.comerCarne());
        Animal vaca = new Vaca();
        System.out.println(comerAnimal(vaca));

    }

    public static String comerAnimal(Animal animal){
        if(animal instanceof Perro){
            return ((Perro) animal).comerCarne();
        }if(animal instanceof Gato){
            return ((Gato) animal).comerCarne();
        }else{
            return ((Vaca) animal).comerHierba();
        }
    }
}
