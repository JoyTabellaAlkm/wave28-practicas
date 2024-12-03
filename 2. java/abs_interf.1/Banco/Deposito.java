package Banco;
public class Deposito implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transaccionNoOk'");
    }
    
}
