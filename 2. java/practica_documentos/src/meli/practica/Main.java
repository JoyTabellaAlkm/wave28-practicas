package practica_documentos.src.meli.practica;

import java.util.ArrayList;

import practica_documentos.src.meli.practica.models.Curriculum;
import practica_documentos.src.meli.practica.models.Informe;
import practica_documentos.src.meli.practica.models.LibroPDF;

public class Main {
    
    public static void main(String[] args) {

        // Curriculum

        ArrayList<String> habilidades = new ArrayList<String>();
        habilidades.add("Java");
        habilidades.add("Spring");
        habilidades.add("Maven");

        Curriculum curriculum = new Curriculum("Santiago", habilidades);
        curriculum.imprimir();

        // Libro PDF

        LibroPDF libroPDF = new LibroPDF("Gabriel Garcia Marquez", "Cien años de soledad", "Drama", 400 );
        libroPDF.imprimir();

        // Informe

        Informe informe = new Informe("Tres tristes tigres", "Santiago", "Juanito", 30);
        informe.imprimir();

    }
}
