package Banco;
public class Pago_de_Servicios implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transaccionNoOk'");
    }
    
}
