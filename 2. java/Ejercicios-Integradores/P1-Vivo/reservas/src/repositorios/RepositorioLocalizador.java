package repositorios;

import clases.Cliente;
import clases.Localizador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores = new ArrayList<>();

    public void guardar(Localizador l) {
        localizadores.add(l);
    }

    public void eliminarPorDni(Localizador l) {
        localizadores.remove(l);
    }

    public long buscarCantidadPorCliente(Cliente c) {
        return
                localizadores.stream().filter(localizador -> localizador.getCliente().getDni() == c.getDni()).count();
    }

}
