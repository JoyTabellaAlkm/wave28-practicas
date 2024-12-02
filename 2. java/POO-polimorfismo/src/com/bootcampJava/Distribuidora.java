package com.bootcampJava;


public class Distribuidora {
    public static void main (String[] args){
        Producto[] productos = {
                new Perecedero("Leche", 1.0, 3),
                new Perecedero("Carne", 7.0, 2),
                new Perecedero("Verduras", 4.0, 2),
                new Perecedero("Frutas", 3.0, 2),
                new Perecedero("Pescado", 1.0, 1),
                new NoPerecedero("Fideos", 2.0, "Alimento"),
                new NoPerecedero("Aceite", 1.5, "Alimento"),
                new NoPerecedero("Conserva", 2.0, "Alimento"),
                new NoPerecedero("Jabon", 1.5, "Limpieza"),
                new NoPerecedero("Detergente", 2.0, "Limpieza")
        };

        double precioTotal = 0;

        for (Producto producto : productos) {
            double precio = producto.calcular(1);
            precioTotal += precio;
        }
        System.out.println("El precio total de los productos es: " + precioTotal);

    }
}
