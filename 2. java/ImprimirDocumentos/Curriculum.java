import java.util.List;

public class Curriculum extends Documento{

    private int edad;
    private List<String> habilidades;

    public Curriculum(String autor, int cantpaginas, int edad, List<String> habilidades) {
        super(autor, cantpaginas);
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String ToString() {
        return "Curriculum de " + getAutor() + "\n"+
                "Edad: " + edad + "\n"+
                "Paginas: " + getCantpaginas() + "\n"+
                "Habilidades: " + habilidades;
    }
}
