public class LibroPDF implements Imprimible {
    Integer paginas;
    String autor;
    String genero;
    String titulo;
    @Override
    public void imprimir() {
        System.out.println(this);
    }

    public LibroPDF(Integer paginas, String autor, String genero, String titulo) {
        this.paginas = paginas;
        this.autor = autor;
        this.genero = genero;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
