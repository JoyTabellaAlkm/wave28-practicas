package Clases;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private List<Reserva> reservas;

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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente(String nombre, String apellido, String dni, List<Reserva> reservas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.reservas = reservas;
    }
}
