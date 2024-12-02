public class ConsultaSaldo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("La consulta de saldo se realizo exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar la consulta de saldo");
    }
}
