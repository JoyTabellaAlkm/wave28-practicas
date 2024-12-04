package Transacciones;

public class Ejecutivo {
    private Deposito deposito = new Deposito();
    private Transferencia transferencia = new Transferencia();

    public void hacerDeposito(){
        System.out.println("Deposito exitoso");
        deposito.trasaccionOk();
    }

    public  void hacerTrasnferencia(){
        System.out.println("Transferencia exitososa");
        transferencia.trasaccionOk();
    }


}
