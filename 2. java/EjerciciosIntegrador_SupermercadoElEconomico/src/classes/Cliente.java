package classes;

import interfaces.ICliente;

public class Cliente implements ICliente {
    private Integer dni;
    private String nombre;
    private String apellido;

    public Cliente(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

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

    @Override
    public void imprimir() {
        System.out.println("Datos del cliente: ");
        System.out.println("Nombre y apellido: "+ this.nombre + " " + this.apellido);
        System.out.println("DNI: " + this.dni);
        System.out.println();
    }

    @Override
    public void editarDatos(String nombre, String apellido, Integer dni) {
        if(nombre != null) this.nombre = nombre;
        if(apellido != null) this.apellido = apellido;
        if(dni != null) this.dni = dni;
    }


}
