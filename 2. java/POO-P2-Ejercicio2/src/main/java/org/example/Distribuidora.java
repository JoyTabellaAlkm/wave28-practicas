
package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public Distribuidora() {
    }

    public static void main(String[] args) {
        List<Perecedero> perecederos = new ArrayList();
        List<NoPerecedero> noPerecederos = new ArrayList();
        perecederos.add(new Perecedero("Queso", 10, 2));
        perecederos.add(new Perecedero("Pan", 20, 3));
        perecederos.add(new Perecedero("Jamon", 30, 5));
        perecederos.add(new Perecedero("Carne", 14, 6));
        perecederos.add(new Perecedero("Banana", 23, 7));

        noPerecederos.add(new NoPerecedero("Arroz", 16, "alimento"));
        noPerecederos.add(new NoPerecedero("Fideos", 20, "alimento"));
        noPerecederos.add(new NoPerecedero("Pure de tomate", 40, "salsa"));
        noPerecederos.add(new NoPerecedero("Legumbres", 11, "enlatado"));
        noPerecederos.add(new NoPerecedero("Cereales", 5, "alimento"));
        System.out.println("Perecederos");

        for(Perecedero perecedero : perecederos) {
            double precio = perecedero.calcular(5);
            System.out.println(perecedero);
            System.out.println(precio);
        }

        System.out.println("noPerecederos");

        for(NoPerecedero noPerecedero : noPerecederos) {
            double precio = noPerecedero.calcular(5);
            System.out.println(noPerecedero);
            System.out.println(precio);
        }

    }
}
