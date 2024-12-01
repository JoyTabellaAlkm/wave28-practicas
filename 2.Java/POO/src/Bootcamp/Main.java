package Bootcamp;

public class Main {
    public static void main(String[] args) {
        Libro Libro = new Libro("Harry Potter", "JK Rowling",20);

        System.out.println( Libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este libro es: "+  Libro.cantidadDeEjemplares());
//TIP
    }
}