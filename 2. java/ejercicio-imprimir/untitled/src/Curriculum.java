import java.util.ArrayList;

public class Curriculum implements Imprimible{
    private Persona persona;
    ArrayList<String> habilidades;

    public Curriculum(Persona persona, ArrayList<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(persona);
        habilidades.forEach(System.out::println);
    }
}
