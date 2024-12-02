import Clientes.Basic;
import Clientes.Ejecutivo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("-----BANCO INTERFACES DEL PAÍS : EJECUTIVO -----");
        Ejecutivo ejec = new Ejecutivo();
        ejec.realizarTransaccion("deposito");
        ejec.realizarTransaccion("transferencia");

        System.out.println("-----BANCO INTERFACES DEL PAÍS : BASIC -----");
        Basic basic = new Basic();
        basic.realizarTransaccion("deposito");
        basic.realizarTransaccion("consultarSaldo");



    }
}