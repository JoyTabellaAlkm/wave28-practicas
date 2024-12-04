import java.util.HashMap;
import java.util.Map;

public class Curriculum implements Impresora{

    private String name;
    private String edad;
    private String cargo;
    private Map<String, Object> habilidades = new HashMap<>();

    public Curriculum(String name, String edad, String cargo, Map<String, Object> habilidades) {
        this.name = name;
        this.edad = edad;
        this.cargo = cargo;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println('\n' + "name='" + name + '\'' +
                ", edad='" + edad + '\'' +
                ", cargo='" + cargo + '\'' +
                ", habilidades=" + habilidades +
                '}' + '\n');
    }
}
