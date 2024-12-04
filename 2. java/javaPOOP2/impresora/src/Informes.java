public class Informes implements Impresora{

    private Integer cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informes(Integer cantidadDePaginas, String autor, String revisor) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    public String obtenerContenido(){
        return "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen.";
    }

    @Override
    public void imprimir(){
        System.out.println('\n'+ obtenerContenido());
    }
}
