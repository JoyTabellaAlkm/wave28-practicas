package practicaClasesAbstractasInterfaces.supermercadoElEconomico.repositorio;

import practicaClasesAbstractasInterfaces.supermercadoElEconomico.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepoClientes {
    List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
