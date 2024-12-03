package org.example;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        Cliente cliente = new Cliente("Cliente", "Apellido", "12345678");

        agencia.procesarReserva(cliente);
    }
}