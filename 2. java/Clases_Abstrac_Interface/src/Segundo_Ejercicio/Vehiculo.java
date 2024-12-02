public class Vehiculo {
    //modelo, marca y costo
    private String modelo;
    private String marca;
    private Integer costo;

    public Vehiculo(String modelo, String marca,Integer costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo [modelo=" + modelo + ", marca=" + marca + ", costo=" + costo + "]";
    }


}