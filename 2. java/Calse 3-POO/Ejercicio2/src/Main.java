import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //PARTE 1 EXCEPCIONES

        PracticaExcepciones practica = new PracticaExcepciones();

        try {
            int resultado = practica.calcular();
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + "No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }

        //PARTE 2 PRODUCTOS

        List<Producto> listaProductos = new ArrayList<Producto>();

        listaProductos.add(new Perecedero("Leche", 2000, 5));
        listaProductos.add(new Perecedero("Pan", 5000, 1));
        listaProductos.add(new Perecedero("Queso", 3000, 2));
        listaProductos.add(new Perecedero("Jamon", 19000, 3));
        listaProductos.add(new Perecedero("Manzana", 1000, 4));

        listaProductos.add(new NoPerecedero("Arroz", 6000, "Legumbre"));
        listaProductos.add(new NoPerecedero("Atun", 2000, "Cereal"));
        listaProductos.add(new NoPerecedero("Harina", 2500, "Legumbre"));
        listaProductos.add(new NoPerecedero("Enlatado", 10000, "Cereal"));
        listaProductos.add(new NoPerecedero("Pasta", 8000, "Conserva"));

        double cantidadTotal = 0;
        for (Producto producto : listaProductos) {
            cantidadTotal = cantidadTotal + producto.calcular(1);
        }
        System.out.println(cantidadTotal);

        Producto producto1 = new Perecedero("Manzana", 1000, 4);
        System.out.println(producto1);
    }
}