import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        
        // Crear productos
        Perecedero perecedero1 = new Perecedero("Leche", 50.0, 1);
        Perecedero perecedero2 = new Perecedero("Yogurt", 30.0, 2);
        NoPerecedero noPerecedero1 = new NoPerecedero("Arveja", 340.0, "2");
        NoPerecedero noPerecedero2 = new NoPerecedero("Arroz", 300.0, "1");
        
        // Añadir productos a la lista
        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        
        // Imprimir precio total por 5 productos de cada tipo
        for (Producto i : productos) {
            double precioTotal = i.calcular(5); 
            System.out.println(i);
            System.out.println("Precio total por 5 unidades: " + precioTotal + "\n");
        }
    }
}
