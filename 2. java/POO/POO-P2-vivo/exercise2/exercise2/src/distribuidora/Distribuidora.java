package distribuidora;

import no_perecedero.NoPerecedero;
import perecedero.Perecedero;
import producto.Producto;

public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[]{
                new Perecedero("Queso", 120, 2),
                new Perecedero("Pan", 50, 3),
                new Perecedero("Jamon", 200, 1),
                new Perecedero("Queso", 120, 4),
                new NoPerecedero("Madera", 200, "Construccion"),
                new Perecedero("Lentejas", 50, 100)
        };

        for(Producto producto: productos) {
            System.out.println(producto);
            double total = producto.calcular(10);
            if(producto.getClass() == Perecedero.class) {
                System.out.println("El producto es perecedero y tiene " + ((Perecedero) producto).getDiasPorCaducar() + " dias por caducar");
            }
            System.out.println("Por 10 unidades de " + producto.getNombre() + " el valor es: " + total);
        }
    }
}
