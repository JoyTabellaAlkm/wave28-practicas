package ejercicios.ejercicio2ClasesAbsInt;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    List<Habilidades> habilidades;

    public Persona(String nombre, String apellido, String habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = new ArrayList<>();
        Habilidades h = new Habilidades(habilidades);
        this.habilidades.add(h);
    }

    @Override
    public String toString() {
        return STR."Persona{nombre='\{nombre}', apellido='\{apellido}', \{habilidades}}";
    }
}
