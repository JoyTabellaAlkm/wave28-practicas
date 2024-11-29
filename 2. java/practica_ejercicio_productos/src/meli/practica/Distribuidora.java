package practica_ejercicio_productos.src.meli.practica;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Perecedero("Fresas", 2500, 2);
        Producto producto2 = new NoPerecedero("Lentejas", 4500, "tipo");

        productos.add(producto1);
        productos.add(producto2);

        double total = 0;
        System.out.println("------------------------------------------");
        for (Producto producto : productos) {
            total += producto.calcular(5);
            System.out.println("El costo de 5 " + producto.getNombre() + " es: " + producto.calcular(5));
        }

        System.out.println("------------------------------------------");
        System.out.println("El total de los productos: " + total);
        System.out.println("------------------------------------------");
    }

}
