import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private List<Producto> productos;


    public Distribuidora() {
        productos = new ArrayList<>();
    }

    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();
        distribuidora.productos.addAll(List.of(
                new Producto("Mesa", 1000.0),
                new NoPerecedero("Fideos", 100.0, "Pasta"),
                new Perecedero("Leche", 200.0, 3),
                new Perecedero("Yogur", 150.0, 2),
                new Perecedero("Huevo", 100.0, 1)));

        for (Producto producto : distribuidora.productos) {
            System.out.println("Precio total al vender 5 unidades del producto individual: " + producto + " | Precio total: " + producto.calcular(5));
        }
    }


}
