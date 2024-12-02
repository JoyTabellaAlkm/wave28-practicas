public class TransaccionEjecutiva implements Transaccion {

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }


    public void deposito(){
        System.out.println("Deposito");
    }
    public void transferencia(){
        System.out.println("Transferencia");
    }


}