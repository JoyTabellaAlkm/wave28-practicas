package EjercicioClase2;

public class Producto {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public double calculate(int quantity){
        return price * quantity;
    }
}
