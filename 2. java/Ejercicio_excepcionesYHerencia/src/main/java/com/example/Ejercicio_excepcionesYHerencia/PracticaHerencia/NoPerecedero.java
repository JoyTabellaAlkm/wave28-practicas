package com.example.Ejercicio_excepcionesYHerencia.PracticaHerencia;

public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" + '\n'+
                "nombre: " + super.getNombre() + '\n' +
                "precio: " + super.getPrecio() + '\n' +
                "tipo='" + tipo + '\n'+
                '}';
    }
}
