package Clases.Cliente;

import Interfaces.ITransaccion;

import java.util.List;

public abstract class Cliente {
    private String nombre;
    private List<ITransaccion> acciones;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void realizarTransaccion();
}
