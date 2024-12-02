package ejercicios.clasesAbstractasInterfaces.ejercicio2ClasesAbsInt;

public class Informes implements Imprimible{
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return STR."Informes{texto='\{texto}', cantPaginas=\{cantPaginas}, autor='\{autor}', revisor='\{revisor}'}";
    }
}
