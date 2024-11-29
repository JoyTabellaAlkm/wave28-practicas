import java.util.List;

public class Distribuidor {

    public static void main(String[] args) {
        List<Producto> listaProductos = List.of(
                new Perecedero("Queso", 350d, 2),
                new Perecedero("Leche",120.4, 1),
                new NoPerecedero("Harina", 50, "Harina 0000"),
                new NoPerecedero("Arroz", 20, "Arroz blanco"),
                new Perecedero("Pan", 10, 3)
        );

        double total = 0;
        for (Producto p : listaProductos) {
            System.out.println("Costo de 5 "+p.getNombre()+"s=" + p.calcular(5));
            total += p.calcular(5);
        }
        System.out.println("Costo total="+total);
    }

}
