package modelos;

import interfaces.ITransaccion;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected List<ITransaccion> transaccionesDisponibles = new ArrayList();


    public Usuario() {
    }

    public void agregarTransaccion(ITransaccion transaccion){

    }

    public void  mostrarTransaccionesOK(){
        transaccionesDisponibles.stream().forEach(t->t.transaccionOk());
    }

    public void  mostrarTransaccionesNoOK(){
        transaccionesDisponibles.stream().forEach(t->t.transaccionNoOk());
    }




}