import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        double total = 0;

        Producto producto1 = new NoPerecedero("Café", 100, "Alimento");
        Producto producto2 = new Perecedero("Carne", 200, 3);
        Producto producto3 = new NoPerecedero("Lavandina", 300, "Limpieza");
        Producto producto4 = new Perecedero("Jamón", 400, 1);
        Producto producto5 = new Perecedero("Huevos", 500, 2);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        for (Producto producto : productos) {
            int random = (int)(Math.random() * 10 + 1);
            total += producto.calcular(random);
        }

        System.out.println(total);
    }
}