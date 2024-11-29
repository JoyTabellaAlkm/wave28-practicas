package meli.practica;

public class Libro {

    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }


    public int cantidaDeEjemplares(){
        return ejemplares;
    }

    public String mostrarLibro(){
        return "titulo: " + titulo + " autor: " + autor + " ejemplares: " + ejemplares;
    }
}