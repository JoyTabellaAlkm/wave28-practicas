import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, List<String>> categorias = new HashMap<>();
        categorias.put(1, new ArrayList<>(List.of("Chico", "2 km por selva y arroyos")));
        categorias.put(2, new ArrayList<>(List.of("Medio", "5 km por selva, arroyos y barro")));
        categorias.put(3, new ArrayList<>(List.of("Avanzado", "10 km por selva, arroyos, barro y escalada en piedra")));

        List<List<Object>> participantes = new ArrayList<>();
        participantes.add(new ArrayList<>(List.of(1, "123", "Pepe", "Juarez", 12, "151515", "101010", "AB+")));
        participantes.add(new ArrayList<>(List.of(2, "421", "Juan", "Perez", 19, "133331", "4124", "O-")));
        participantes.add(new ArrayList<>(List.of(3, "745", "Ernesto", "Lopez", 32, "3452345", "5432345", "B+")));

        //La inscripción guarda la llave de la categoría en la Key y el número del participante en el value
        HashMap<Integer, List<Object>> inscripciones = new HashMap<>();
        for(int i = 0; i < participantes.size(); i++) {
            calcularInscripcion(participantes.get(i), categorias.get(i+1).getFirst());
            inscripciones.put(i+1, participantes.get(i));
        }

        System.out.println("===============================================");

        System.out.println("Lista de inscripciones: ");
        for(Map.Entry<Integer, List<String>> entry : categorias.entrySet()) {
            System.out.println("La categoria " + entry.getValue().getFirst() + " tiene inscritos: ");
            for(Map.Entry<Integer, List<Object>> inscripcion : inscripciones.entrySet()) {
                if(inscripcion.getKey() == entry.getKey()) {
                    System.out.println(inscripcion.getValue());
                }
            }
        }

        System.out.println("===============================================");

        inscripciones.remove(1);
        System.out.println("Lista de inscritos a "+ categorias.get(1).getFirst() +": ");
        if(inscripciones.get(1) == null){
            System.out.println("No hay inscritos");
        }

        System.out.println("===============================================");

        int sumaTotal = 0;

        System.out.println("Recaudado por categoria: ");
        for(Map.Entry<Integer, List<String>> entry : categorias.entrySet()) {
            int sumaCategoria = 0;
            for(Map.Entry<Integer, List<Object>> inscripcion : inscripciones.entrySet()) {
                if(inscripcion.getKey() == entry.getKey()) {
                    sumaCategoria += calcularInscripcion(inscripcion.getValue(), entry.getValue().getFirst());
                    sumaTotal += sumaCategoria;
                }
            }
            System.out.println("La categoria " + entry.getValue().getFirst() + " recaudó: "+sumaCategoria);
        }

        System.out.println("===============================================");

        System.out.println("Total recaudado en la carrera: " + sumaTotal);

    }

    public static int calcularInscripcion(List<Object> participante, String categoria) {
        switch (categoria) {
            case "Chico":
                if((int) participante.get(4) > 18){
                    System.out.println("El participante "+participante.get(2)+" debe pagar $1.300");
                    return 1300;
                }else{
                    System.out.println("El participante "+participante.get(2)+" debe pagar $1.500");
                    return 1500;
                }
            case "Medio":
                if((int) participante.get(4) > 18){
                    System.out.println("El participante "+participante.get(2)+" debe pagar $2.000");
                    return 2000;
                }else{
                    System.out.println("El participante "+participante.get(2)+" debe pagar $2.300");
                    return 2300;
                }
            case "Avanzado":
                if((int) participante.get(4) < 18){
                    System.out.println("El participante no puede ser menor de edad");
                    return 0;
                }else{
                    System.out.println("El participante "+participante.get(2)+" debe pagar $2.800");
                    return 2800;
                }
            default:
                return 0;
        }
    }
}