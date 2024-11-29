package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

public class Distribuidora {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Leche", 5000, 5));
        productos.add(new Perecedero("Queso", 3000, 2));
        productos.add(new Perecedero("Carne", 7000, 3));
        productos.add(new Perecedero("Verduras", 4000, 4));
        productos.add(new Perecedero("Manzana", 2000, 1));

        double total = 0;
        for(Producto producto: productos) {
            total += producto.calcular(rand.nextInt(10));
        }
        System.out.println("El precio de los alimentos perecederos es: " + total);
        double totalPerecederos = total;

        productos.add(new NoPerecedero("Camiseta", 35000, "Ropa"));
        productos.add(new NoPerecedero("Toallas", 23000, "Limpieza"));
        productos.add(new NoPerecedero("Herramientas", 77000, "Hogar"));
        productos.add(new NoPerecedero("Boleto", 150000, "Entretenimiento"));
        productos.add(new NoPerecedero("Bolígrafo", 2000, "Papelería"));

        total = 0;
        for (int i = 5; i < productos.size(); i++) {
            total += productos.get(i).calcular(rand.nextInt(4));
        }
        System.out.println("El precio de los alimentos NO perecederos es: " + total);

        System.out.println("El precio de toda la compra es de "+(total+totalPerecederos));
    }
}
