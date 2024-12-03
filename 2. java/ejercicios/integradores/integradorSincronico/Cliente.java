package ejercicios.integradores.integradorSincronico;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int dni;
    private String nombre;
    private List<Localizador> localizadores;
    public Cliente(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }
    public int getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public List<Localizador> getLocalizadores() {
        return localizadores;
    }
    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }
    public boolean tieneMasDeDosLocalizadores()
    {
        return localizadores.size() >= 2;
    }
    @Override
    public String toString() {
        return STR."Cliente{dni=\{dni}, nombre='\{nombre}'";
    }
}

