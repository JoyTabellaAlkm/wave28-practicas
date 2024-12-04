package ejercicio2Imprimir;

import java.util.List;

public class MainEj2 {
    public static void main(String[] args) {
        IImprimir cv = new Curriculum("Juan Ignacio", "Abarca Vecchio",
                22, "Universitario", List.of("Trabajo en equipo", "Codear en Java, Python, C#"));
        IImprimir libroPDF = new LibroPDF("Harry Potter","Juanito",
                356, "Ficcion");
        IImprimir informe = new Informe("En este informe se da a entender como el texto ingresado debe ser largo" +
                "teniendo un tamaño un poco mas grande de lo normal que cualquier otro atributo", 2,
                "Juan Ignacio", "Santiago");

        cv.imprimir();
        libroPDF.imprimir();
        informe.imprimir();
    }
}
