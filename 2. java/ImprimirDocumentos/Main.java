import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Documento cv = new Curriculum("Juan Gomez",1,22,new ArrayList<>());
        Documento informe = new Informe("Pedro Palo",5,"este es un informe ejemplo","Dr. Humberto J.");
        Documento libro = new LibroPDF("Robert T.K.",400,"Finanzas","Padre rico Padre pobre");

        IImprimible.Imprimir(libro);
        System.out.println();
        IImprimible.Imprimir(cv);
        System.out.println();
        IImprimible.Imprimir(informe);
        System.out.println();
    }
}