package com.polimorfismo;

import com.polimorfismo.productos.NoPerecedero;
import com.polimorfismo.productos.Perecedero;
import com.polimorfismo.productos.Producto;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("productoPadre", 10));
        productos.add(new Perecedero("productoPerecedero1", 10,1));
        productos.add(new Perecedero("productoPerecedero2", 10,2));
        productos.add(new Perecedero("productoPerecedero3", 10,3));
        productos.add(new NoPerecedero("productoNoPerecedero", 10, "piola"));

        for (Producto prod:
             productos) {
            System.out.println("Precio del producto " + prod.getNombre()+":"+prod.calcular(5));
            if (prod.getClass() == Perecedero.class){
                System.out.println("dias por caducar: "+ ((Perecedero) prod).getDiasPorCaducar());
            } else if (prod.getClass() == NoPerecedero.class) {
                System.out.println("Tipo de producto no perecedero: "+ ((NoPerecedero) prod).getTipo());
            }
            System.out.println();
        }
    }
}