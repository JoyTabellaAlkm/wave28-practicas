import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private List<Transaccion> acciones = new ArrayList<>();

    public void realizarAccion(Transaccion accion) {
        if (!acciones.contains(accion)) {
            // throw new Exception("No puede realizar esta accion");
        }
        // aca se puede realizar logica para saber
        // si la accion se realizo o no con exito
        accion.transaccionOk();
    }

    public void cederAccion(Transaccion accion) {
        acciones.add(accion);
    }
}
