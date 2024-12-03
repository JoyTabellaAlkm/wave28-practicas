package AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private Integer DNI;

    private List<Localizador> localizadores;

    public Cliente(String nombre, Integer DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }
}
