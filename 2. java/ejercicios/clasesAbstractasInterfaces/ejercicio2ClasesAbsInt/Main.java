package ejercicios.clasesAbstractasInterfaces.ejercicio2ClasesAbsInt;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Carolina", "Schwab", "Correr");
        Curriculum curriculum = new Curriculum(p);

        PDF pdf = new PDF(3,"nombre","titulo","genero");

        Informes informes = new Informes("texto", 5, "autor", "revisor");

        System.out.println(Imprimible.imprimir(curriculum));
        System.out.println(Imprimible.imprimir(pdf));
        System.out.println(Imprimible.imprimir(informes));


    }
}
