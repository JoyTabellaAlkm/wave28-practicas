package practicaClasesAbstractasInterfaces.PracticaReservas.Servicios;

import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Clientes;
import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Localizadores;

import java.util.List;

public interface ILocalizadores {
    Localizadores crearLocalizador(Clientes cliente, List<String> listaReserva);
}
