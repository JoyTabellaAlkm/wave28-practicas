package Imprimibles;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----IMPRIMIENDO PDF-----");
        LibroPDF pdf = new LibroPDF("infantil",3,"Hermanos grim","Caperusita Roja");
        pdf.imprimir("Documento impreso");

        System.out.println("-----IMPRIMIENDO CV-----");
        Curriculum cv = new Curriculum("Juana","cv","12345678","30");
        pdf.imprimir("Documento Cv");

    }
}
