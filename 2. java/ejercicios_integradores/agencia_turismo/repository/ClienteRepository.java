package ejercicios_integradores.agencia_turismo.repository;

import ejercicios_integradores.agencia_turismo.domain.Cliente;

public class ClienteRepository extends GenericRepository<Cliente, String> {
    @Override
    public Cliente buscarPorId(String id) {
        return this.listObjetos.stream().filter(c -> c.getDni().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void crear(Cliente obj) {
        this.listObjetos.add(obj);
        System.out.println("-- Se ha agregado al cliente " + obj);
    }
}
