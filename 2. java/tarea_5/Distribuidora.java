package tarea_5;

import java.util.ArrayList;

public class Distribuidora {
  public static void main(String[] args) {
    ArrayList<Producto> productos = new ArrayList<Producto>();
    Perecedero p1 = new Perecedero("Perecedero1", 100, 2);
    Perecedero p2 = new Perecedero("Perecedero2", 200, 2);
    Perecedero p3 = new Perecedero("Perecedero3", 300, 2);
    NoPerecedero np1 = new NoPerecedero("NoPerecedero1", 1,"2");
    NoPerecedero np2 = new NoPerecedero("NoPerecedero1", 1,"2");
    productos.add(p1);
    productos.add(p2);
    productos.add(p3);
    productos.add(np1);
    productos.add(np2);

    double venta = 0;
    int cantidad = 2;
    for(Producto p : productos){
      venta += p.calcular(cantidad);
      System.out.println("Producto: " + p.getNombre() + ", Cantidad: " + cantidad);
      cantidad += 3;
    }
    System.out.println("Total: " + venta);
  }
}
