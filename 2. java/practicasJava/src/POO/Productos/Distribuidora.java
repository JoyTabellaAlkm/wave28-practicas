package POO.Productos;

import java.util.*;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        Producto producto1 = new Perecedero("Aguacate",5.500,1);
        Producto producto2 = new NoPerecedero("Arroz",3.500,"tipo");

        productos.add(producto1);
        productos.add(producto2);

        double total = 0;
        for (Producto producto: productos) {

            total +=producto.calcular(5);
        }

        System.out.println("El total de los producto es : " +total);


    }
}
