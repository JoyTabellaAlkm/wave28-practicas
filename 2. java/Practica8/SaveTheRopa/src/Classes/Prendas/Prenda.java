package Classes.Prendas;

public abstract class Prenda {
    // ATTRIBUTES
    private String marca;
    private String modelo;

    // CONSTRUCT
    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // GETTERS & SETTERS
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // toString

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
