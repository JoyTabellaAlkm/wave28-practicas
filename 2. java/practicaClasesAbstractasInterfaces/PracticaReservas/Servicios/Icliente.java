package practicaClasesAbstractasInterfaces.PracticaReservas.Servicios;

import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Clientes;

import java.util.Optional;

public interface Icliente {
    Clientes crearCliente(String nombre, String dni);
    Optional<Clientes> consultaCliente (String dni);
}
