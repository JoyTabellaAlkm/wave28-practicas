package practicaClasesAbstractasInterfaces.interfazImprimible.entidades;

public class Informe extends Documento {
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe() {
    }

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getautor() {
        return autor;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }

    public int getcantPaginas() {
        return cantPaginas;
    }

    public void setcantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String gettexto() {
        return texto;
    }

    public void settexto(String texto) {
        this.texto = texto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
