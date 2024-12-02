package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImpresorDocumento {
    public static void main(String[] args) {
        List<Documento> documentos = new ArrayList<>();
        documentos.add(new Curriculum(20, "Mariano" , "Lopez", "Programador"));
        documentos.add(new Informe("Soy un informe", 20, "Jose", "Juan"));
        documentos.add(new LibroPdf(10, "Hector", "Libro", "Terror"));

        for (Documento documento : documentos) {
            IImpresorDocumento.imprimir(documento);
        }
    }
}
