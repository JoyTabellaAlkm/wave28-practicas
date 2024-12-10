public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro("Cien años de soledad ", "Gabriel Garcia Marquez ", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("Numero de ejemplares: " + libro.mostrarEjemplares());
    }
}