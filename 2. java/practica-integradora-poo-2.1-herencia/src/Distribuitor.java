import Entities.NonPerishableProduct;
import Entities.PerishableProduct;
import Entities.Product;

public class Distribuitor {
    public static void main(String[] args) {
        Product[] products = {
                new PerishableProduct("Bread", 2.99, 1),
                new PerishableProduct("Lettuce", 1.49, 2),
                new PerishableProduct("Egg", 3.49, 3),
                new PerishableProduct("Dragon Fruit", 249.99, 21),
                new NonPerishableProduct("GPU", 699.99, "Computer Component"),
        };

        for (Product product : products){
            product.toString();
            System.out.println("Selling 5 of these costs: " + product.calculate(5));
        }

    }
}
