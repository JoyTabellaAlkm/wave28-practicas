package meli.practica;

public class Main {

    public static void main(String[] args) {

        Libro libro = new Libro("Harry Potter", "J. K. Rowling", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares es: " + libro.cantidaDeEjemplares());
    }
}