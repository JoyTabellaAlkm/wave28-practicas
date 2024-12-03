package Clases;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private List<Localizador> localizadores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizador(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public Cliente(String nombre, String apellido, String dni, List<Localizador> localizadores) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.localizadores = localizadores;
    }
}
