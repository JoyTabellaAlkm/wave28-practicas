public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Cliente setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Cliente setDni(String dni) {
        this.dni = dni;
        return this;
    }

}
