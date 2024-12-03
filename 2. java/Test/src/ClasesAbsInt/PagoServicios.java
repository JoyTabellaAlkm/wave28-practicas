package ClasesAbsInt;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("PagoServicios ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("PagoServicios no ok");
    }
}
