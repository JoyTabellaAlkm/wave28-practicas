public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Martín", "Simonetti", "31469095", 39);
        Informe inf = new Informe("Este es el texto del informe.", 3, "Martín Simonetti", "Fernanda Simonetti");
        LibroPDF libro = new LibroPDF("Educación", 20, "Martín Simonetti", "Bootcamp en Meli");

        cv.agregarHabilidad("Java");
        cv.agregarHabilidad("JavaScript");

        cv.imprimir();
        inf.imprimir();
        libro.imprimir();
    }
}