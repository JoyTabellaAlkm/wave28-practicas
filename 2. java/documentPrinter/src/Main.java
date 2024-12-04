import documents.BookInPdf;
import documents.Curriculum;
import documents.Report;
import printer.IPrintable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Santiago", "12345", 27, "santiago@mail.com", List.of("Trabajo en equipo", "Responsabilidad"));
        BookInPdf book = new BookInPdf(134, "Pablo Neruda", "Los versos del capitán", "Drama");
        Report report = new Report("Reporte de ventas 2024", 48, "Luisa Calderón", "Diana García");

        IPrintable.printDocument(curriculum);
        IPrintable.printDocument(book);
        IPrintable.printDocument(report);

    }
}