package ejercicios.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Categoria circuitoChico = new CircuitoChico("2 km por selva y arroyos.","Circuito chico", 1);
        Categoria circuitoMedio = new CircuitoMedio("5 km por selva, arroyos y barro.","Circuito medio", 2);
        Categoria circuitoAvanzado = new CircuitoAvanzado("10 km por selva, arroyos, barro y escalada en piedra.","Circuito avanzado", 3);

        Participante participante1 = new Participante("caro", "sch", 27, 1, 492829,293299, 929292,"B+");
        Participante participante2 = new Participante("carla", "ss", 27, 2, 492829,293299, 929292,"B+");
        Participante participante3 = new Participante("caro", "sch", 27, 3, 492829,293299, 929292,"B+");

        List<Participante> participantes = new ArrayList<>();

        List<Inscripciones> inscripciones = new ArrayList<>();
        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);

        for (int i=0; i < 3; i++) {
            Scanner entrada = new Scanner(System.in);
            Participante participante = participantes.get(i);
            int abonoP1 = 0;
            System.out.println("Introduzca el nombre del inscripcion: ");
            String categoria = entrada.nextLine();
            if (participante.getEdad() > 18) {
                switch (categoria) {
                    case "circuito chico":
                        abonoP1 = 1500;
                    case "circuito medio":
                        abonoP1 = 2300;
                    case "circuito avanzado":
                        abonoP1 = 2800;
                }
            } else {
                switch (categoria) {
                    case "circuito chico":
                        abonoP1 = 1300;
                    case "circuito medio":
                        abonoP1 = 2000;
                    case "circuito avanzado":
                        abonoP1 = 2800;
                }
            }
            Inscripciones inscripcion = new Inscripciones(i, circuitoChico, participante, abonoP1);
            inscripciones.add(inscripcion);
        }
        for (Inscripciones inscripcion : inscripciones) {
            System.out.println(inscripcion);

        }

    }
}
