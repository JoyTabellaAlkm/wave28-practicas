package practica_documentos.src.meli.practica.models;

public class LibroPDF implements IImprimible {

    private int numeroPaginas;
    private String nombreAutor, titulo, genero;

    public LibroPDF(String nombreAutor, String titulo, String genero, int numeroPaginas){
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("-----------------------------");
        System.out.println("El libro se llama: " + titulo);
        System.out.println(numeroPaginas + " páginas");
        System.out.println("Autor: " + nombreAutor);
        System.out.println("Género: " + genero);
        System.out.println("-----------------------------");
    }

}
