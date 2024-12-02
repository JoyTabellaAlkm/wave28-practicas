package ejercicios.ejercicio2ClasesAbsInt;

public class PDF implements Imprimible{
    private int cantPags;
    private String nombre;
    private String titulo;
    private String genero;

    public PDF(int cantPags, String nombre, String titulo, String genero) {
        this.cantPags = cantPags;
        this.nombre = nombre;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return STR."PDF{cantPags=\{cantPags}, nombre='\{nombre}', titulo='\{titulo}', genero='\{genero}'}";
    }
}
