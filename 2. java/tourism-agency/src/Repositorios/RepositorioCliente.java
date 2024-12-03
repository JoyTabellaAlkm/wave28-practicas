package Repositorios;

import Entidades.*;
import Repositorios.Interfaces.IRepositorioCliente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepositorioCliente {
    // ATTRIBUTES
    private List<Cliente> clientes;

    // CONSTRUCTOR
    public RepositorioCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public RepositorioCliente(){
        this.clientes = new ArrayList<>();
    }

    // GETS & SETS
    public List<Cliente> getClientes() {
        return clientes;
    }


    // METHODS
    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }


    /// FROM INTERFACE
    @Override
    public List<Reserva> buscarReservas() {
        return null;
    }

    @Override
    public double aplicarDescuentos() {
        return 0;
    }
}
