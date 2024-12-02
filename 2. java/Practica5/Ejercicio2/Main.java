import bootcamp.classes.Book;
import bootcamp.classes.Curriculum;
import bootcamp.classes.Report;
import bootcamp.interfaces.Imprimible;

public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Jorge", "Calderón", 35);
        cv.setSkill("Java");
        cv.setSkill("Javascript");
        Book book = new Book("Jorge Calderón", "Un día más en Java", "Educación", 5);
        Report report = new Report("Este es el texto del reporte", 2, "Jorge Calderón", "Alguien");

        Imprimible.printDocument(cv);
        System.out.println("\n");
        Imprimible.printDocument(book);
        System.out.println("\n");
        Imprimible.printDocument(report);


    }
}