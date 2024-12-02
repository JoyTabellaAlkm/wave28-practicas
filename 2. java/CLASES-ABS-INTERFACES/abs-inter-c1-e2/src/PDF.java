public class PDF extends Documento {

    private String genero;
    private int cantiPaginas;
    private String autor;
    private String titulo;

    public PDF(String documento, String genero, int cantiPaginas, String autor, String titulo) {
        super(documento);
        this.genero = genero;
        this.cantiPaginas = cantiPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimirDocumento(String documento) {
        System.out.println("Imprimiendo documento " + documento);
    }
}
