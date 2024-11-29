import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Producto> productosPerecederos = new ArrayList<>();
        ArrayList<Producto> productosNoPerecederos = new ArrayList<>();

        Perecedero carne = new Perecedero("Carne", 100, 5);
        Perecedero yogurt = new Perecedero("Yogurt", 20.5, 2);
        Perecedero queso = new Perecedero("Queso", 20.0, 1);
        Perecedero manzana = new Perecedero("Manzana", 3.25, 3);
        Perecedero banana = new Perecedero("Banana", 4.5, 4);

        NoPerecedero pureDeTomate = new NoPerecedero("Pure de Tomate", 6.7, "alimento");
        NoPerecedero salsaDeMostaza = new NoPerecedero("Salsa de Mostaza", 15.7, "alimento");
        NoPerecedero lataDeAtun = new NoPerecedero("Lata de Atun", 8.7, "alimento");
        NoPerecedero llantaCarro = new NoPerecedero("Llanta carro", 50, "repuesto");
        NoPerecedero alicate = new NoPerecedero("Alicate", 43, "herramienta");

        productosPerecederos.add(carne);
        productosPerecederos.add(yogurt);
        productosPerecederos.add(queso);
        productosPerecederos.add(manzana);
        productosPerecederos.add(banana);

        productosNoPerecederos.add(pureDeTomate);
        productosNoPerecederos.add(salsaDeMostaza);
        productosNoPerecederos.add(lataDeAtun);
        productosNoPerecederos.add(llantaCarro);
        productosNoPerecederos.add(alicate);

        productos.add(yogurt);
        productos.add(queso);
        productos.add(manzana);
        productos.add(llantaCarro);
        productos.add(alicate);

        double totalProductosPerecederos = calcularTotalProductos(productosPerecederos);
        double totalProductosNoPerecederos = calcularTotalProductos(productosNoPerecederos);
        double totalProductos = calcularTotalProductos(productos);


        System.out.println("Total Productos Perecederos: " + totalProductosPerecederos);
        System.out.println("Total Productos No Perecederos: " + totalProductosNoPerecederos);
        System.out.println("Total Productos : " + totalProductos);

    }

    public static double calcularTotalProductos(ArrayList<Producto> productos) {
        double total = 0;

        for(Producto producto: productos) {
            total += producto.calcular(1);
        }

        return total;
    }
}