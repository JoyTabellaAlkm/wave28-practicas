package agenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {

    List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void listarClientes(){
        System.out.println("-----------------");
        for(Cliente c: clientes){
            System.out.println("Identificación: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Localizadores con sus reservas:");
            for(Localizador localizador: c.localizadores){
                System.out.println("-----------------");
                localizador.listarReservas();
                System.out.println("Se hizo un descuento de: " + localizador.getDescuento() + "%");
                System.out.println("-----------------");
            }
        }
    }

}