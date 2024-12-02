public class Informe implements Imprimible{
    private int cantidadPaginas;
    private String nombreAutor;
    private String texto;
    private String nombreRevisor;


    public Informe(int cantidadPaginas, String nombreAutor, String texto, String nombreRevisor) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.texto = texto;
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe{" +
            "cantidadPaginas=" + cantidadPaginas +
                    ", nombreAutor='" + nombreAutor + '\'' +
                    ", texto='" + texto + '\'' +
                    ", nombreRevisor='" + nombreRevisor + '\'' +
                    '}');
    }
}
