package Banco;
public class Retiro_de_Efectivo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro de efectivo");
    }

    @Override
    public void transaccionNoOk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transaccionNoOk'");
    }
    
}
