package ClasesAbsInt;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    String nombre;
    protected List<Transaccion> transacciones;

    public Cliente(String nombre) {
        this.nombre = nombre;
        transacciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void realizarTransaccion(Transaccion transaccion) {
        System.out.println(nombre+" esta realizando una transaccion ");
        if (transacciones.stream().anyMatch(t-> t.getClass().equals(transaccion.getClass()))) {
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
