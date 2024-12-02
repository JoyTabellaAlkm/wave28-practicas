import Entities.Curriculum;
import Entities.PdfBook;
import Entities.Person;
import Entities.Report;
import Interfaces.IPrintable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IPrintable> toPrint = new ArrayList<IPrintable>();
        toPrint.add(new Curriculum(
                new Person(41, "Luis", "Sierra"),
                new ArrayList<>(Arrays.asList(
                        "Cooperative",
                        "Comprehensive",
                        "Empathic",
                        "Dilligent",
                        "Good with words"
                ))
        ));
        toPrint.add(new PdfBook(31, "Bjarne Stroupstorm", "C Tips", "Technology"));
        toPrint.add(new Report(21331, 53, "Marcos Duglas", "Michel Angelo"));

        for(IPrintable printable : toPrint){
            System.out.println(printable.print());
        }
    }
}
