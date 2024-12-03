package Banco.Transacciones;

public class Operacion implements iTransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Operacion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Operacion no exitosa");
    }
}
