package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora;

public interface IImprimible<T> {

    static<T> void imprimir(T t){
        System.out.println(t.toString());
    }
}
