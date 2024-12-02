public class TransaccionCobradores implements Transaccion {


    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    public void retiroEfectivo() {
        System.out.println("Retiro efectivo");
    }
    public void consultaSaldo(){
        System.out.println("Consulta saldo");

    }
}