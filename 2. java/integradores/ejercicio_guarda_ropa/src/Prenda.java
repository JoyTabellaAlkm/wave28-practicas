public class Prenda {
    private String marca;
    private String Modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        Modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                '}';
    }
}
