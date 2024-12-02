import java.util.ArrayList;
import java.util.Arrays;

public class Distribuidora {
    public static void main(String [] argv){
        ArrayList<Producto> productos = new ArrayList<>();
        NoPerecedero producto1 = new NoPerecedero("Arroz",1000.00,"cereales");
        NoPerecedero producto2 = new NoPerecedero("Harina 000",1500.00,"panaderia");
        NoPerecedero producto3 = new NoPerecedero("Leche en polvo",600.00,"lacteos");
        Perecedero producto4 = new Perecedero("Banana",1000.00,2);
        Perecedero producto5 = new Perecedero("Carne",1000.00,1);

        productos.addAll(Arrays.asList(producto1,producto2,producto3,producto4,producto5));

        Double total = 0.0;

        for (Producto p: productos) {
            Double calculo =p.calcular(5);
            total += calculo;
            System.out.println("x5 "+ p.getNombre()+" = "+ calculo);
        }
        System.out.println("TOTAL = "+ total);

    }

}
