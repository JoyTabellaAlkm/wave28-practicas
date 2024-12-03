package Banco;
public class Transferencia implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose transferencia");
    }

    @Override
    public void transaccionNoOk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transaccionNoOk'");
    }
    
}
