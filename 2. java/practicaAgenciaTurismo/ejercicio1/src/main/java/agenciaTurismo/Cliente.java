package agenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String id;
    String nombre;
    List<Localizador> localizadores;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public List<Localizador> obtenerLocalizadores(){
        return localizadores;
    }

    public int cantidadLocalizadores(){
        return localizadores.size();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}