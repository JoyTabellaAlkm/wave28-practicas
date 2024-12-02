package org.example;

public class NoPerecedero extends Producto {
    String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }
}
