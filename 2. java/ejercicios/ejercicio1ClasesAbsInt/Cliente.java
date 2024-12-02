package ejercicios.ejercicio1ClasesAbsInt;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    List<String> transacciones = new ArrayList<>();
    public void hacerTransaccion(Transaccion t){
        if (transacciones.contains(t.getClass().getSimpleName())){
            System.out.println("Realizandose deposito");
            t.transaccionOk();
        }
        else{
            t.transaccionNoOk();
        }
    };
}
