package practicaClasesAbstractasInterfaces.PracticaReservas.repositorios;

import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Clientes;

import java.util.ArrayList;
import java.util.List;

public class RespositorioClientes {
    public List<Clientes> listClientes = new ArrayList<>();

    public List<Clientes> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Clientes> listClientes) {
        this.listClientes = listClientes;
    }

    public RespositorioClientes(List<Clientes> listClientes) {
        this.listClientes = listClientes;
    }

    public RespositorioClientes() {
    }
}
