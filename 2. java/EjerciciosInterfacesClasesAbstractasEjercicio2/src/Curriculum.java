public class Curriculum implements IImprimible{

    private String nombre;
    private String apellido;
    private String dni;
    private int tel;
    private String[] habilidades;

    public Curriculum(String nombre, String apellido, String dni, int tel, String[] habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.tel = tel;
        this.habilidades = habilidades;
    }

    @Override
    public String obtenerContenido() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("Curriculum de ").append(nombre).append(" ").append(apellido).append(" ").append("DNI: ").append(dni).append("\n");
        contenido.append("Telefono: ").append(tel).append("\n");
        contenido.append("Habilidades: ");
        for (String habilidad:habilidades){
            contenido.append(habilidad).append(", ");
        }
        return contenido.toString();
    }
}
