import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) throws Exception {
        Perecedero producto1 = new Perecedero("yogurt",5000,3);
        Perecedero producto2 = new Perecedero("queso", 12000, 2);
        Perecedero producto3 = new Perecedero("leche", 4500, 2);
        Perecedero producto4 = new Perecedero("mantequilla", 8000, 3);
        Perecedero producto5 = new Perecedero("pan", 2500, 1);

        NoPerecedero noPerecedero1 = new NoPerecedero("atun", 4500, "enlatado");
        NoPerecedero noPerecedero2 = new NoPerecedero("arroz", 3000, "grano");
        NoPerecedero noPerecedero3 = new NoPerecedero("azucar", 2500, "endulzante");
        NoPerecedero noPerecedero4 = new NoPerecedero("aceite", 8500, "líquido");
        NoPerecedero noPerecedero5 = new NoPerecedero("galletas", 5000, "empacado");

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);

        for (Producto producto : productos) {
            System.out.println(producto.calcular(5));
        }


    }
}
