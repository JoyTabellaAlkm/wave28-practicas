package com.mercadolibre;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.clientes.Basic;
import com.mercadolibre.clientes.Cliente;
import com.mercadolibre.clientes.Cobradores;
import com.mercadolibre.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Ejecutivo());
        clientes.add(new Basic());
        clientes.add(new Cobradores());

        for (Cliente cliente : clientes) {
            cliente.realizarTransacciones();
        }
    }
}