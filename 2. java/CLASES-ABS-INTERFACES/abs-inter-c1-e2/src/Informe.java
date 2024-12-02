public class Informe extends Documento {

    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String documento, String texto, int cantidadDePaginas, String autor, String revisor) {
        super(documento);
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimirDocumento(String documento) {
        System.out.println("Imprimiendo documento " + documento);
    }
}
