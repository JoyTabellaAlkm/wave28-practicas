package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_2;

public class LibroPDF implements Imprimible {
    private Persona autor;
    private String titulo;
    private String genero;
    private Integer cantidadPaginas;

    public LibroPDF(Persona autor, Integer cantidadPaginas, String genero, String titulo) {
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "autor=" + autor +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}

