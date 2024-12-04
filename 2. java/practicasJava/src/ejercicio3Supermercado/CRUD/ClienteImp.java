package ejercicio3Supermercado.CRUD;

import ejercicio3Supermercado.model.Cliente;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ClienteImp implements ICRUD<Cliente>{
    Set<Cliente> clienteSet = new HashSet<Cliente>();

    @Override
    public void crearInstancia(Cliente obj) {
        clienteSet.add(obj);
    }

    @Override
    public void mostrarInstancias() {
        clienteSet.stream().forEach(x->System.out.println(x.getNombre()+" "+
                x.getApellido()+" tiene el siguiente DNI "+x.getDni()));
    }

    @Override
    public void eliminarInstancia(Long dniBorrado) {
        Optional<Cliente> cliente = this.consultarInstancia(dniBorrado);

        if (cliente.isEmpty()){
            System.out.println("No se encontro el cliente a borrar");
        } else{
            System.out.println("Se borro correctamente");
            clienteSet.remove(cliente.get());
        }
    }

    @Override
    public Optional<Cliente> consultarInstancia(Long dniBuscado) {
        Boolean dniEncontrado = false;
        for (Cliente c : clienteSet){
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("El Cliente se encontro ");
                System.out.println(c.getNombre()+" "+
                        c.getApellido()+" tiene el siguiente DNI "+c.getDni());
                return Optional.of(c);
            }
        }
        if (dniEncontrado == false) {
            System.out.println("No se encontro el cliente a buscar");
        }

        return Optional.empty();
    }

    @Override
    public List<Cliente> consultarLista() {
        return List.of();
    }
}
