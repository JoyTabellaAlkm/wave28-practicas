package ejercicios.deportista.dto;

public class PersonaDTO {
    private String Nombre;
    private String Apellido;
    private String Edad;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, String edad) {
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
