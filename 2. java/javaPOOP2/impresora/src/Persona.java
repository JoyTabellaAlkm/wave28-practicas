import java.util.HashMap;
import java.util.Map;

public class Persona {
    /*
        Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
    */

    private String name;
    private String edad;
    private String cargo;
    private Map<String, Object> habilidades = new HashMap<>();

    public Persona(String name, String edad, String cargo, Map<String, Object> habilidades) {
        this.name = name;
        this.edad = edad;
        this.cargo = cargo;
        this.habilidades = habilidades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
