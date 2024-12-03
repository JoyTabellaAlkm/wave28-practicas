import java.util.List;

public class Curriculums implements Imprimible {
    private Persona persona;
    private List<String> habilidades; 

    
    public Curriculums(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }


    public Persona getPersona() {
        return persona;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public List<String> getHabilidades() {
        return habilidades;
    }


    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }


    @Override
    public String toString() {
        return "Curriculums [persona=" + persona + ", habilidades=" + habilidades + "]";
    }

}