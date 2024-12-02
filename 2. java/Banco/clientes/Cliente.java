package clientes;

import java.util.ArrayList;
import java.util.List;

import transacciones.Transaccion;

public abstract class Cliente {

    private String nombre;
    protected List<Transaccion> transacciones;

    public Cliente(String nombre) {
        transacciones = new ArrayList<>();
        this.nombre = nombre;
    }

    public void realizarTransacciones() {
        System.out.println("Realizando transacciones para el cliente: " + nombre);
        for (Transaccion transaccion : transacciones) {
            transaccion.transaccionOk();
        }
    }

}
