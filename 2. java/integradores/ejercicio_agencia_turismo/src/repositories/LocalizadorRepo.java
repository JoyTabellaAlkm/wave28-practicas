package repositories;

import classes.Cliente;
import classes.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepo {
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
