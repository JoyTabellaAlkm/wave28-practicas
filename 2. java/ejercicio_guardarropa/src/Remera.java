public class Remera extends Prenda{
    public Remera(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String toString() {
        return "Remera{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}