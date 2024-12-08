package interfaces;

public class Informes implements IImprimible{

    String longitud;
    int cantPaginas:
    Persona autor;
    Persona revisor;

    public Informes(String longitud, int cantPaginas, Persona autor, Persona revisor) {
        this.longitud = longitud;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "longitud='" + longitud + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor=" + autor +
                ", revisor=" + revisor +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
