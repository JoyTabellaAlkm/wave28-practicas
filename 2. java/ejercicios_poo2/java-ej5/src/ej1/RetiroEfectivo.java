package ej1;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Efectivo retirado exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido entregar el efectivo");
    }
}
