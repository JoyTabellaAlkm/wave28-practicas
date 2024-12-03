package practicaClasesAbstractasInterfaces.interfazImprimible;

import practicaClasesAbstractasInterfaces.interfazImprimible.entidades.Curriculum;
import practicaClasesAbstractasInterfaces.interfazImprimible.entidades.Documento;
import practicaClasesAbstractasInterfaces.interfazImprimible.entidades.Informe;
import practicaClasesAbstractasInterfaces.interfazImprimible.entidades.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Documento documenInforme = new Informe();
        Documento documentoCurriculum = new Curriculum();
        Documento documentoLibro = new Libro();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de documento a imprimir: ");
        System.out.println("1_ Informe. ");
        System.out.println("2_ Curriculum. ");
        System.out.println("3_ Libro. ");

        int opcion = scanner.nextInt();
        System.out.println(opcion);
        if (opcion != 1 || opcion != 2 || opcion != 3 ) {
            System.out.println("Ingrese el tipo de documento a imprimir: ");
        }

        switch (opcion) {
            case 1:
                documenInforme.imprimir();
                break;
            case 2:
                documentoCurriculum.imprimir();
                break;
            case 3:
                documentoLibro.imprimir();
                break;
        }

    }
}
