
public class Libros implements Impresora{
    private int cantidadDePagina = 0;
    private String nameAutor;
    private String genero;

    public Libros(int cantidadDePagina, String nameAutor, String genero) {
        this.cantidadDePagina = cantidadDePagina;
        this.nameAutor = nameAutor;
        this.genero = genero;
    }

    @Override
    public void imprimir(){
        System.out.println('\n' + "Imprimiendo Libro con los siguiente datos "+ "No:"+ cantidadDePagina + "Nombre del autor: " + nameAutor + "Genero "+ genero);
    }






}
