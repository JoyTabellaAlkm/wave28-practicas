public abstract class Documento implements IImprimible {

    private String autor;
    private int cantpaginas;

    public Documento(String autor, int cantpaginas) {
        this.autor = autor;
        this.cantpaginas = cantpaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantpaginas() {
        return cantpaginas;
    }

    public abstract String getTipo();
    public abstract String ToString();
}
