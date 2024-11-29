package ejerciciosPracticos;

import java.util.*;

public class CarreraSelva {
    public static void main(String[] args) {
        /*categorias*/
        Map<Integer, Map<String, String>> categorias = new HashMap<>();

        Map<String, String> categoria1 = new HashMap<>();
        categoria1.put("id", "1");
        categoria1.put("nombre", "Circuito Chico");
        categoria1.put("Descripcion", "2 km por selva y arroyo");
        categorias.put(1, categoria1);


        Map<String, String> categoria2 = new HashMap<>();
        categoria2.put("id", "2");
        categoria2.put("nombre", "Circuito Medio");
        categoria2.put("Descripcion", "5 km por selva, arroyos y barro");
        categorias.put(2, categoria2);

        Map<String, String> categoria3 = new HashMap<>();
        categoria3.put("id", "3");
        categoria3.put("nombre", "Circuito Avanzado");
        categoria3.put("Descripcion", "10 km por selva,arroyos,barro y escalada en piedra");
        categorias.put(3, categoria3);

        for (Map.Entry<Integer, Map<String, String>> entrada : categorias.entrySet()) {
            Integer clave = entrada.getKey();
            String valor = entrada.getValue().toString();
            System.out.println(clave + "  " + valor);

        }
        /* Participantes */
        Map<Integer, Map<String, String>> participantes = new HashMap<>();
        participantes.put(1, Map.of("numeroParticipante", "10", "dni", "1122123560", "nombre",
                "Zully", "apellido", "Tamayo", "edad", "36", "celular", "3175954140",
                "numeroEmergencia", "3123435435", "grupoSanguineo", "O+"));
        participantes.put(2, Map.of("numeroParticipante", "10", "dni", "11234532", "nombre",
                "Eilin", "apellido", "Restrepo", "edad", "23", "celular", "366654140",
                "numeroEmergencia", "312425435", "grupoSanguineo", "A+"));
        participantes.put(3, Map.of("numeroParticipante", "10", "dni", "11234532", "nombre",
                "Azucena", "apellido", "Panez", "edad", "26", "celular", "332294140",
                "numeroEmergencia", "312421135", "grupoSanguineo", "A-"));
        participantes.put(4, Map.of("numeroParticipante", "10", "dni", "11234532", "nombre",
                "Nadina", "apellido", "Ambar", "edad", "25", "celular", "33194140",
                "numeroEmergencia", "31121135", "grupoSanguineo", "AB"));


        System.out.println(participantes);

        /* inscripciones al azar */
        Map<String, Map<String, Object>> inscripciones = new HashMap<>();
        Random random = new Random();

        int monto = calcularMonto("1", 12);
        System.out.println(monto);

    }

    /* calcular montos */
    static int calcularMonto(String categoria, int edad) {
        if (categoria.equals("1")) {
            return (edad < 18) ? 1300 : 1500;
        } else if (categoria.equals("2")) {
            return (edad < 18) ? 2000 : 2300;
        }else if(categoria.equals("3")){
            return (edad>=18)? 2800:-1; //no se permiten menores de edad en esta categoria
        }
        return -1; //categoría inválida

    }

}

