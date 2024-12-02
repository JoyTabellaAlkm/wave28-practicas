public class Transferencia implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("La transferencia se realizo exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar la transferencia");
    }
}
