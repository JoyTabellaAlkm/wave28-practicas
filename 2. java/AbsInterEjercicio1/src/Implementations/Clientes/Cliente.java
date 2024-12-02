package Implementations.Clientes;

import Interfaces.ITransaccion;

public abstract class Cliente {
    String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void realizarTransaccion(ITransaccion ITransaccion);
}
