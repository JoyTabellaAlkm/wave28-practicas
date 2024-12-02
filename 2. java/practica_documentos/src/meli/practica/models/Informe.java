package practica_documentos.src.meli.practica.models;

public class Informe implements IImprimible {

    private String texto;
    private int numeroPaginas;
    private String nombreAutor;
    private String nombreRevisor;

    public Informe(String texto, String nombreAutor, String nombreRevisor, int numeroPaginas){
        this.texto = texto;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void imprimir(){
        System.out.println("-----------------------------");
        System.out.println("El texto es el siguiente: " + this.texto);
        System.out.println("El autor es: " + this.nombreAutor);
        System.out.println("El revisor es: " + this.nombreRevisor);
        System.out.println("Número de páginas: " + this.numeroPaginas + " páginas");
        System.out.println("-----------------------------");
    }

}
