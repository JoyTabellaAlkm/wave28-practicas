package Imprimibles;

public class Informe extends Docuemento {

    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;

    }

    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo Informe: " + texto + "\nContenido: " + documento);
    }

    @Override
    public void imprimirTipoDoc() {
        System.out.println("Tipo de documento: Informe");
    }



    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
