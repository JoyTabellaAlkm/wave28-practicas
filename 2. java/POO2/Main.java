import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> products= new ArrayList<>();
        double total = 0;

        Producto product1 = new Perecedero("leche", 200, 1);
        Producto product2 = new Perecedero("Atun", 400, 3);
        Producto product3 = new Perecedero("Huevo", 600, 2);
        Producto product4 = new NoPerecedero("javon", 400, "Aseo");
        Producto product5 = new NoPerecedero("Cafe", 400, "Alimento");

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        for (Producto product : products) {
            int random = (int)(Math.random() * 10 + 1);
            total += product.calculate(random);
        }
        System.out.println(total);
    }
}
