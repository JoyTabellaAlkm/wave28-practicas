public class Informe implements Imprimible{
    private int longitud;
    private int cantidadDePaginas;
    private Persona autor;
    private Persona revisor;

    public Informe(int longitud, int cantidadDePaginas, Persona autor, Persona revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
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
        return "Informe [longitud=" + longitud + ", cantidadDePaginas=" + cantidadDePaginas + ", autor=" + autor
                + ", revisor=" + revisor + "]";
    }

    
    
}