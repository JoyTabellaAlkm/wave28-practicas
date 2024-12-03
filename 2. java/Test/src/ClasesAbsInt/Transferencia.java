package ClasesAbsInt;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no ok");
    }
}
