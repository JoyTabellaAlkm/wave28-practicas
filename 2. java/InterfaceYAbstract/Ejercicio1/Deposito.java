public class Deposito implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El deposito se realizo exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el deposito");
    }
}
