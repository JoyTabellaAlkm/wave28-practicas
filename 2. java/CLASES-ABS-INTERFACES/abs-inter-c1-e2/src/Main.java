//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Informe informeUno = new Informe("informe", "untexto", 22, "Paula", "Juana");
        informeUno.imprimirDocumento("informe");

        Curriculum curriculumFer = new Curriculum("curriculum", "Fer", "Castaldo", "4857568", 76);
        curriculumFer.imprimirDocumento("curriculum");

        PDF pdfFer = new PDF("pdf", "investigacion", 76, "Maria", "Luz");
        pdfFer.imprimirDocumento("pdf");
    }
}