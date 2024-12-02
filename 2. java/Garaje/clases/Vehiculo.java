package clases;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int precio;

    public Vehiculo(String marca, String modelo, int precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return """
                Marca: %s
                Modelo: %s
                Precio: %s
                """.formatted(this.marca, this.modelo, this.precio);
    }
}
