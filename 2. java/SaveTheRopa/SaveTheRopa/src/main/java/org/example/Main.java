package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Camisa","Shein");
        Prenda prenda2 = new Prenda("Pantalon","American Eagle");
        GuardaRopa guardar = new GuardaRopa();
        Integer identificador = guardar.guardarPrendas(List.of(prenda1,prenda2));
        guardar.guardarPrendas(List.of(prenda1,prenda2));

        System.out.println(identificador);
        guardar.mostrarPrendas();
        guardar.devolverPrendas(identificador);
        guardar.mostrarPrendas();
    }
}