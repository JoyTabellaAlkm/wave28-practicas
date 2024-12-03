package com.example.EjerciciosIntegradores_parte1.Supermercado;

import java.util.ArrayList;
import java.util.List;

public class RepoClientes {
    List<Cliente> listaCliente;

    public RepoClientes() {
        this.listaCliente = new ArrayList<>();
    }


    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    public boolean esClienteAdherido(Cliente cliente){
        return listaCliente.stream().anyMatch(c -> c.getDni().equals(cliente.getDni()));
    }

    public void agregarCliente(Cliente cliente){
        if(esClienteAdherido(cliente)){
            System.out.println("El cliente ya se encuentra adherido");
        }else {
            listaCliente.add(cliente);
            System.out.println("Se añadió el cliente correctamente");
        }

    }

}
