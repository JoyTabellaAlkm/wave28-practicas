import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Perecedero("Alfajor", 1000, 2);
        Producto producto2 = new NoPerecedero("Harina", 700, "Alimento");

        productos.add(producto1);
        productos.add(producto2);

        for (Producto producto : productos) {
            producto.toString();
            System.out.println("El precio de 5 productos: " + producto.getNombre() + " es de: " + producto.calcular(5));
        }
    }
}
