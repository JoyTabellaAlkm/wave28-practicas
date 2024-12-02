import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Producto[] productos = {
                new Perecedero("leche",1500, 2),
                new Perecedero("brocoli",2040.10, 3),
                new Perecedero("durazno",140.20, 2),
                new Perecedero("carne",1500.20, 3),
                new Perecedero("pollo",1200.20, 1),
                new NoPerecedero("Fideos", 2.0, "Alimento"),
                new NoPerecedero("Aceite", 1.5, "Alimento"),
                new NoPerecedero("Conserva", 2.0, "Alimento"),
                new NoPerecedero("Jabon", 1.5, "Limpieza"),
                new NoPerecedero("Detergente", 2.0, "Limpieza")
        };

        double total = 0;
        Random random = new Random();
        for(Producto producto : productos) {
            total += producto.calcular(random.nextInt(5) + 1);
        }
        System.out.println(total);
    }
}