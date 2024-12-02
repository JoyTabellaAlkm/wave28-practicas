package ej1;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("La informacion del saldo se ha mostrado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al consultar el saldo");
    }
}
