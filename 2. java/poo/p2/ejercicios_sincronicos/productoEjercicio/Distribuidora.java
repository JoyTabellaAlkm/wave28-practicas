package poo.p2.ejercicios_sincronicos.productoEjercicio;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();

        // Creamos los productos perecederos y no perecederos
        NoPerecedero noPerecedero1 = new NoPerecedero("Harina 0000", 1000, "Panaderia");
        NoPerecedero noPerecedero2 = new NoPerecedero("Harina 000", 890, "Panaderia");
        NoPerecedero noPerecedero3 = new NoPerecedero("Lata de arbejas", 600, "Enlatados");
        Perecedero perecedero1 = new Perecedero("Banana", 300, 2);
        Perecedero perecedero2 = new Perecedero("Manzana", 600, 3);
        Perecedero perecedero3 = new Perecedero("Carne picada especial 500g", 2500, 1);

        // Cargamos la lista con los productos creados
        listaProductos.add(noPerecedero1);
        listaProductos.add(noPerecedero2);
        listaProductos.add(noPerecedero3);
        listaProductos.add(perecedero1);
        listaProductos.add(perecedero2);
        listaProductos.add(perecedero3);

        // imprimimos los precios de comprar x5 cada producto y total de la "compra"
        double totalCompra = 0;
        for(Producto producto: listaProductos) {
           double total = producto.calcular(5);
           System.out.println("x5 - \""+producto.getNombre()+"\": AR$"+total);
           totalCompra += total;
        }
        System.out.println("CANTIDAD DE PRODUCTOS COMPRADOS: " + listaProductos.size() * 5);
        System.out.println("PRECIO TOTAL: AR$" + totalCompra);
    }
}
