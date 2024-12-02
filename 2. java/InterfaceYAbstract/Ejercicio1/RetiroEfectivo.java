public class RetiroEfectivo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El retiro de efectivo se realizo exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el retiro de efectivo");
    }
}
