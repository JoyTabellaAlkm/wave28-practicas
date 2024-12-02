public class LibroPDF extends  Documento{

    private String genero;
    private String titulo;

    public LibroPDF(String autor, int cantpaginas, String genero, String titulo) {
        super(autor, cantpaginas);
        this.genero = genero;
        this.titulo = titulo;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String ToString() {
        return "Libro de " + getAutor() + "\n"+
                "Titulo: " + titulo + "\n"+
                "Paginas: " + getCantpaginas() + "\n"+
                "Genero: " + genero;
    }
}
