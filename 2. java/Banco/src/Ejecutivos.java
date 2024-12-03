public class Ejecutivos implements IDeposito {
    @Override
    public void hacerDeposito(boolean estado) {
        System.out.println("Se está realizando depósito");

        if(estado){
            this.transaccionOk();
        } else {
            this.transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito no pudo realizarse.");
    }
}
