package EjercicioClase2;
import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {



        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Carne", 8000, 1));

        productos.add(new NoPerecedero("Fideos", 800, "Pasta"));




        for (Producto producto : productos) {
            System.out.println("El precio total de 5 productos de: " + producto.getName() + " es " + producto.calculate(5));
        }

    }
}