package ClasesAbsInt;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro efectivo Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro efectivo No Ok");
    }
}
