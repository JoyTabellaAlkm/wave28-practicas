package practica_carrera_selva.src.meli.practica;

import practica_carrera_selva.src.meli.practica.models.*;
import practica_carrera_selva.src.meli.practica.services.CarreraService;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        CarreraService carreraService = new CarreraService();

        Participante participante1 = new Participante(1, "12345678", "Juan", "Pérez", 21, "123456789", "987654321", "O+");
        carreraService.inscribirParticipante(participante1, 1);

        Random random = new Random();

        Participante participante2 = new Participante(2, "87654321", "Ana", "Gómez", 17, "234567890", "876543210", "A+");
        Participante participante3 = new Participante(3, "11223344", "Luis", "Martínez", 25, "345678912", "765432109", "B-");
        Participante participante4 = new Participante(4, "22334455", "Sofía", "López", 19, "456789012", "654321098", "AB+");
        Participante participante5 = new Participante(5, "33445566", "Miguel", "Fernández", 22, "567890123", "543210987", "O-");
        Participante participante6 = new Participante(6, "44556677", "Lucía", "Rodríguez", 23, "678901234", "432109876", "B+");
        Participante participante7 = new Participante(7, "55667788", "Carlos", "Díaz", 18, "789012345", "321098765", "A-");
        Participante participante8 = new Participante(8, "66778899", "Valentina", "Pérez", 30, "890123456", "210987654", "AB-");

        carreraService.inscribirParticipante(participante2, random.nextInt(2) + 1);
        carreraService.inscribirParticipante(participante3, 3);
        carreraService.inscribirParticipante(participante4, random.nextInt(3) + 1);
        carreraService.inscribirParticipante(participante5, random.nextInt(3) + 1);
        carreraService.inscribirParticipante(participante6, random.nextInt(3) + 1);
        carreraService.inscribirParticipante(participante7, random.nextInt(3) + 1);
        carreraService.inscribirParticipante(participante8, random.nextInt(3) + 1);
        
        int categoriaParaMostrar = 1;
        carreraService.mostrarInscripcionesPorCategoria(categoriaParaMostrar);

        carreraService.desinscribirParticipante(1);
        carreraService.mostrarInscripcionesPorCategoria(categoriaParaMostrar);

        for (int i = 1; i <= 3; i++) {
            double totalCategoria = carreraService.calcularTotalRecaudadoPorCategoria(i);
            System.out.println("Total recaudado para la categoría " + i + ": $" + totalCategoria);
        }
        
        double totalRecaudado = carreraService.calcularTotalRecaudado();
        System.out.println("Total recaudado de todas las categorías: $" + totalRecaudado);
    }
}