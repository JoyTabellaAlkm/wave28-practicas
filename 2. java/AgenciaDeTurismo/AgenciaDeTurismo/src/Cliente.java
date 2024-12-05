
public class Cliente {
    private int id;
    private String nombre;
    private String apellido;

    public Cliente(int id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setId(String Apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return "Nombre y Apellido:  " + getNombre() + " "+ getApellido();
    }
}
