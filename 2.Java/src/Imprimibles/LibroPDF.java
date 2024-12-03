package Imprimibles;

public class LibroPDF extends Docuemento{
    private String genero;
    private int cantPaginas;
    private String autor;
    private String titulo;

    public LibroPDF(String genero, int cantPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo PDF: " + documento);
    }

    @Override
    public void imprimirTipoDoc() {
        System.out.println("Tipo de documento: LIBRO PDF");
    }
}
