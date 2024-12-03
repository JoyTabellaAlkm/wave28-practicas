package Repositorios;

import Entidades.Localizador;
import Repositorios.Interfaces.IRepositorioLocalizador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements IRepositorioLocalizador {
    private List<Localizador> localizadores;

    // CONSTRUCTOR
    public RepositorioLocalizador(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public RepositorioLocalizador(){
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizadores(Localizador localizador){
        this.localizadores.add(localizador);
        imprimir(localizador);
    }

    // GETS & SETS
    public List<Localizador> getLocalizadores() {
        return this.localizadores;
    }

    @Override
    public void imprimir() {

    }

    public void imprimir(Localizador localizador){
        System.out.println(localizador);
    }

}
