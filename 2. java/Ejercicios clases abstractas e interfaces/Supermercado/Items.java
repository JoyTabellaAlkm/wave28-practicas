package org.example;

public class Items {

    private int cod;
    private String nombre;
    private int cant;
    private int costo;

    public Items(int cod, String nombre, int cant, int costo) {
        this.cod = cod;
        this.nombre = nombre;
        this.cant = cant;
        this.costo = costo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
