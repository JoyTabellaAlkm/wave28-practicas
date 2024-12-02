package org.example.model;

import org.example.Transacciones;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected List<Transacciones> transaccionesDisponibles = new ArrayList();


    public Usuario() {

    }

    public void agregarTransaccion(Transacciones transaccion){

    }

    public void  mostrarTransaccionesOK(){
        transaccionesDisponibles.stream().forEach(t->t.transaccionOk());
    }

    public void  mostrarTransaccionesNoOK(){
        transaccionesDisponibles.stream().forEach(t->t.transaccionNoOk());
    }




}
