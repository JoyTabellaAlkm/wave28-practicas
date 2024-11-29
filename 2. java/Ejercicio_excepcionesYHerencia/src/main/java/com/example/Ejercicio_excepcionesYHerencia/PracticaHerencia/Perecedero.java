package com.example.Ejercicio_excepcionesYHerencia.PracticaHerencia;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    public int getDiasPorCaducar(){return this.diasPorCaducar;}
    public void setDiasPorCaducar(int diasPorCaducar){
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public String toString(){
        return "Producto Perecedero {" + '\n' +
                "nombre: " + super.getNombre() + '\n' +
                "precio: " + super.getPrecio() + '\n' +
                "días por caducar: " + diasPorCaducar + '\n' +
                "}";
    }

    @Override
    public double calcular(int cantidadDeProductos){
        switch (diasPorCaducar){
            case 1:
                return super.calcular(cantidadDeProductos)/4;
            case 2:
                return super.calcular(cantidadDeProductos)/3;
            case 3:
                return super.calcular(cantidadDeProductos)/2;
            default:
                return super.calcular(cantidadDeProductos);
        }
    }

}
