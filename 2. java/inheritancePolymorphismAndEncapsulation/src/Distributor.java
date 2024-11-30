import java.util.ArrayList;
import java.util.List;

public class Distributor {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Perishable("Leche", 2500, 1));
        products.add(new NonPerishable("Harina", 3000, "Harinas"));
        products.add(new Perishable("Queso", 4200, 2));
        products.add(new NonPerishable("Azucar", 1300, "Comestibles"));
        products.add(new Perishable("Carne", 12800, 3));
        products.add(new NonPerishable("Zucaritas", 8000, "Cereales"));
        products.add(new Perishable("Manzanas", 7900, 4));
        products.add(new NonPerishable("Sal", 3000, "Comestibles"));
        products.add(new Perishable("Huevos", 700, 2));
        products.add(new NonPerishable("Arroz", 2100, "Cereales"));

        double totalPrice = 0;
        double price = 0;
        int quantity;
        for (Product product : products){
            quantity = (int) ((10 * Math.random()) + 1 );
            price = product.calculate(quantity);
            totalPrice += price;
            System.out.printf("Producto: %s, Cantidad: %d, Precio unitario: %,.2f, Total: %,.2f\n", product.getName(), quantity, product.getPrice(), price);
        }

        System.out.printf("\nEl precio total de los productos es de %,.2f pesos", totalPrice);
    }
}