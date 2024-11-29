public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro("Harry Potter", "JK Rowling", 20);

        System.out.println(libro.mostrarlibro());
        System.out.println("La cantidad de ejemplares para este libro es: " + libro.cantidadEjemplares());

    }
}