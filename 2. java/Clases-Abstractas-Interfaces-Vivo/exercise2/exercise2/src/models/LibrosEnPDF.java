package interfaces;

public class LibrosEnPDF implements IImprimible{

    String titulo;
    String genero;
    int cantidadDePaginas;
    String nombreDeAutor;

    public LibrosEnPDF(String titulo, String genero, int cantidadDePaginas, String nombreDeAutor) {
        this.titulo = titulo;
        this.genero = genero;
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDeAutor = nombreDeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreDeAutor() {
        return nombreDeAutor;
    }

    public void setNombreDeAutor(String nombreDeAutor) {
        this.nombreDeAutor = nombreDeAutor;
    }

    @Override
    public String toString() {
        return "LibrosEnPDF{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", nombreDeAutor='" + nombreDeAutor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
