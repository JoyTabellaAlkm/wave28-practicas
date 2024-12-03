public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Francisco","Caloia",23);
        Informe informe = new Informe("asdfasdfasdfasdfasdf","Francisco","Caloia",1);
        LibroPDF libro = new LibroPDF(1,"Francisco","Caloia","Sobre");
        Impresora.imprimir(curriculum);
        Impresora.imprimir(libro);
        Impresora.imprimir(informe);

    }
}
