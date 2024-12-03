package ClasesAbsInt;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta saldo ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta saldo no ok");
    }
}
