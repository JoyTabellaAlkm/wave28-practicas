package Banco;
public class Consulta_de_Saldo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transaccionNoOk'");
    }
    
}
