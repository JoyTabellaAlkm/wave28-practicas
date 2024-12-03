package Banco;

import Banco.Clientes.Ejecutivo;

public class MainBanco {
    public static void main(String[] args) {
        Ejecutivo ejec1 = new Ejecutivo();
        Transaccion dep1 = new Deposito();
        ejec1.realizarTransaccion(dep1);
        
    }
}
