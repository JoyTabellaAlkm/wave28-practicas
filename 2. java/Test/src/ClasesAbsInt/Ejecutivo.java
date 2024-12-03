package ClasesAbsInt;

public class Ejecutivo extends Cliente {
    public Ejecutivo(String nombre) {
        super(nombre);
        transacciones.add(new Deposito());
        transacciones.add(new Transferencia());
    }
}
