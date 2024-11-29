package meli.practica.ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Perecedero> productosPerecedero = new ArrayList<>();
        ArrayList<NoPerecedero> productosNoPerecedero = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();

        Perecedero perecedero1 = new Perecedero("Atun", 10, 1);
        Perecedero perecedero2 = new Perecedero("Manzana", 5, 2);
        Perecedero perecedero3 = new Perecedero("Habichuela", 15, 3);
        Perecedero perecedero4 = new Perecedero("Choclo", 20, 4);
        Perecedero perecedero5 = new Perecedero("Mermelada", 12, 5);

        NoPerecedero noPerecedero1 = new NoPerecedero("Leche", 5, "Caja");
        NoPerecedero noPerecedero2 = new NoPerecedero("Garbanzo", 3, "Bolsa");
        NoPerecedero noPerecedero3 = new NoPerecedero("Aceite", 10, "Botella");
        NoPerecedero noPerecedero4 = new NoPerecedero("Arroz", 7, "Bolsa");
        NoPerecedero noPerecedero5 = new NoPerecedero("Fideos", 9, "Bolsa");

        productosPerecedero.add(perecedero1);
        productosPerecedero.add(perecedero2);
        productosPerecedero.add(perecedero3);
        productosPerecedero.add(perecedero4);
        productosPerecedero.add(perecedero5);

        productosNoPerecedero.add(noPerecedero1);
        productosNoPerecedero.add(noPerecedero2);
        productosNoPerecedero.add(noPerecedero3);
        productosNoPerecedero.add(noPerecedero4);
        productosNoPerecedero.add(noPerecedero5);

        productos.add(perecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero5);
        productos.add(perecedero3);
        productos.add(noPerecedero4);

        System.out.println(perecedero1.calcularPrecio(5));

        double precioTotal = 0;

        for (Perecedero producto : productosPerecedero) {
            double precio = producto.calcularPrecio(1);
            precioTotal += precio;
        }

        System.out.println("Precio total perecedero: " + precioTotal);

        double precioTotalNoPerecedero = 0;

        for (NoPerecedero noPerecedero : productosNoPerecedero) {
            double precio = noPerecedero.calcularPrecio(1);
            precioTotalNoPerecedero += precio;
        }

        System.out.println("Precio total no perecedero: " + precioTotalNoPerecedero);


        double precioTotalMixto = 0;

        for (Producto producto : productos) {
            double precio = producto.calcularPrecio(1);
            precioTotalMixto += precio;
        }

        System.out.println("Precio total mixto: " + precioTotalMixto);
    }
}