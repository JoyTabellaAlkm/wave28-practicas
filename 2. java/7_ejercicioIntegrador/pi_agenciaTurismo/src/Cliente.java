import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer dni;
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(Integer dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}