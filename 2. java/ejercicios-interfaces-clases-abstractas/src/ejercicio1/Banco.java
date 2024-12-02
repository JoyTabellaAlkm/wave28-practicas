package ejercicio1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Banco {
    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.consultaDeSaldo();
        basic.retiroDeEfectivo();
        basic.pagoDeServicios();

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.transferencia();
        ejecutivo.deposito();

        Cobradores cobradores = new Cobradores();
        cobradores.consultaDeSaldo();
        cobradores.retiroDeEfectivo();
    }
}