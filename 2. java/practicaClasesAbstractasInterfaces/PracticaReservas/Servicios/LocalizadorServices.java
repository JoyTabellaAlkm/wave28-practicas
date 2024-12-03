package practicaClasesAbstractasInterfaces.PracticaReservas.Servicios;

import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Clientes;
import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Localizadores;
import practicaClasesAbstractasInterfaces.PracticaReservas.repositorios.RepositorioLocalizadores;

import java.util.List;

public class LocalizadorServices implements ILocalizadores{

    RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();

    public LocalizadorServices(RepositorioLocalizadores repositorioLocalizadores) {
        this.repositorioLocalizadores = repositorioLocalizadores;
    }

    @Override
    public Localizadores crearLocalizador(Clientes cliente, List<String> listaReserva) {
        Localizadores nuevoLocalizador = new Localizadores(cliente, listaReserva);
        repositorioLocalizadores.localizadores.add(nuevoLocalizador);
        return nuevoLocalizador;
    }
}
