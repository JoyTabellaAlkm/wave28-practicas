package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_2;

public class Informe implements Imprimible {
    private String textoContenido;
    private Integer cantidadPaginas;
    private Persona autor;
    private Persona revisor;

    public Informe(Persona autor, Integer cantidadPaginas, Persona revisor, String textoContenido) {
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.revisor = revisor;
        this.textoContenido = textoContenido;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public void setTextoContenido(String textoContenido) {
        this.textoContenido = textoContenido;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Informe{" +
                "autor=" + autor +
                ", cantidadPaginas=" + cantidadPaginas +
                ", revisor=" + revisor +
                ", textoContenido='" + textoContenido + '\'' +
                '}';
    }
}
