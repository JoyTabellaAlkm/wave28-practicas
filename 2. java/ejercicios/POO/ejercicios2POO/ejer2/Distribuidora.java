package ejercicios.POO.ejercicios2POO.ejer2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();

        Producto producto1 = new Perecedero("algo", 20, 3);

        Producto producto2 = new NoPerecedero("algo2", 20, "tipo");


        productos.add(producto1);
        productos.add(producto2);

        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcular(5);
        }

        System.out.println("El total de los productos: " + total);
    }

}
