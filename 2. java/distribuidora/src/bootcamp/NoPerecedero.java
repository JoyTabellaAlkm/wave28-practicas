package bootcamp;
public class NoPerecedero extends Producto {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NoPerecedero(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "type='" + type + '\'' +
                '}';
    }
}
