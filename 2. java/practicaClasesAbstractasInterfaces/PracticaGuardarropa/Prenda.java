package practicaClasesAbstractasInterfaces.PracticaGuardarropa;

public class Prenda {
    private String marca;
    private String modelo;
    private int id;

    public Prenda() {
    }

    public Prenda(String marca, String modelo, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", id=" + id +
                '}';
    }
}
