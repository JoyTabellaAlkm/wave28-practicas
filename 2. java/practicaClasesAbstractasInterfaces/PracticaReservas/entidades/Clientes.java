package practicaClasesAbstractasInterfaces.PracticaReservas.entidades;

import java.util.List;

public class Clientes {
        private String nombre;
        private String dni;
        private List<Localizadores> listaLocalizadores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Localizadores> getListaLocalizadores() {
        return listaLocalizadores;
    }

    public void setListaLocalizadores(List<Localizadores> listaLocalizadores) {
        this.listaLocalizadores = listaLocalizadores;
    }

    public Clientes(String nombre, String dni, List<Localizadores> listaLocalizadores) {
        this.nombre = nombre;
        this.dni = dni;
        this.listaLocalizadores = listaLocalizadores;
    }

    public Clientes(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Clientes() {
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", listaLocalizadores=" + listaLocalizadores +
                '}';
    }
}
