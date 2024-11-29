package com.company;

public class Automovil {
    String marca;
    String color;
    double kilometros;

    public Automovil() {

    }

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }


    public void mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + marca + ". El color del auto es: " + color;
    }
}
