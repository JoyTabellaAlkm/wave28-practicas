package org.example;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores = new ArrayList<>();

    public void agregar(Localizador localizador) {
        localizadores.add(localizador);
    }

    public List<Localizador> buscarLocalizador(Cliente cliente) {
        List<Localizador> localizadoresCliente = new ArrayList<>();

        for(Localizador loc : localizadores) {
            if(loc.getCliente().equals(cliente)) {
                localizadoresCliente.add(loc);
            }
        }

        return localizadoresCliente;
    }

}