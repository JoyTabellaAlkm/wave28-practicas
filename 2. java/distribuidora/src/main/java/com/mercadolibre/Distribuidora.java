package com.mercadolibre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] perecederos = {
                new Perecedero("Frijol enlatado", 2000, 5),
                new Perecedero("Banano", 3000, 3),
                new Perecedero("Manzana", 1000, 2),
                new Perecedero("Tomate", 500, 1),
                new Perecedero("Cebolla", 700, 3)
        };

        Producto[] noPerecederos = {
                new NoPerecedero("Desodorante", 2000, "Granos"),
                new NoPerecedero("Jabón", 3000, "Condimento"),
                new NoPerecedero("Azucar", 1000, "Dulce"),
                new NoPerecedero("Papel higiénico", 500, "Grasa"),
                new NoPerecedero("Vinagre", 700, "Acido")
        };

        List<Producto> productos = new ArrayList<>();
        productos.addAll(Arrays.asList(perecederos));
        productos.addAll(Arrays.asList(noPerecederos));

        for (Producto producto : productos) {
            double totalCompra = producto.calcular(5);
            System.out.println("El total de la compra para 5 artículos del producto " + producto.getNombre() + " es: "
                    + totalCompra);
        }

    }
}