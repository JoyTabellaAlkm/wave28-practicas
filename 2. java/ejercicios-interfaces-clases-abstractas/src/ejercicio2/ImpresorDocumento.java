package ejercicio2;

import ejercicio2.clases.Curriculum;
import ejercicio2.clases.Documento;
import ejercicio2.clases.Informe;
import ejercicio2.clases.LibroPdf;
import ejercicio2.interfaces.IImpresorDocumento;

import java.util.ArrayList;
import java.util.List;

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
