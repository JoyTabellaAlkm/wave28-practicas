public class Cliente {
//    De cada cliente se registran: dni, nombre y apellido
    private String dni ;
    private String nombre;
    private String apellido;

    public Cliente ( String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }

    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }
    public void setDni(java.lang.String dni) {
        this.dni = dni;
    }
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

}
