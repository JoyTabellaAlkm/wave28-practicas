import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;

    List<Localizador> localizadores;

    public Cliente(String nombre, String dni, List<Localizador> localizadores) {
        this.nombre = nombre;
        this.dni = dni;
        this.localizadores = localizadores;
    }

    public void agregarlocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }

    public void cantidadlocalizador() {
        this.localizadores.size();
    }
}
