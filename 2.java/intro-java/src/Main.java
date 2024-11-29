import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        int totalChico = 0;
        int totalMedio = 0;
        int totalAvanzado = 0;
        int totalCarrera = 0;

        Map<Integer, String> circuito = new HashMap<>();
        circuito.put(1, "Chico");
        circuito.put(2, "Medio");
        circuito.put(3, "Avanzado");

        Map<String, String> persona = new HashMap<>(); //persona-identificación
        Map<String, String> inscripcion = new HashMap<>(); //persona-inscripcion
        Map<String, String> categoria = new HashMap<>();//persona-categoria
        Map<String, Integer> edades = new HashMap<>();//persona-categoria
        Map<String, Integer> valores = new HashMap<>();//persona-categoria

        persona.put("12345", "Nicolas");
        inscripcion.put("12345", "0001");
        categoria.put("12345", circuito.get(1));
        edades.put("12345", 23);

        persona.put("1234", "Dario");
        inscripcion.put("1234", "0002");
        categoria.put("1234", circuito.get(2));
        edades.put("1234", 48);

        persona.put("9876", "Pilar");
        inscripcion.put("9876", "0003");
        categoria.put("9876", circuito.get(3));
        edades.put("9876", 50);

        Scanner sc = new Scanner(System.in);
        String opcion;
        do {
            totalChico = 0;
            totalMedio = 0;
            totalAvanzado = 0;
            totalCarrera = 0;
            for (Map.Entry<String, String> p : persona.entrySet()) {
                String dni = p.getKey();
                String categ = categoria.get(dni);
                Integer edad = edades.get(dni);

                if (categ.equalsIgnoreCase("Chico")) {
                    if (edad < 18) {
                        valores.put(dni, 1300);
                    } else {
                        valores.put(dni, 1500);
                    }
                    totalChico += valores.get(dni);
                } else if (categ.equalsIgnoreCase("Medio")) {
                    if (edad < 18) {
                        valores.put(dni, 2000);
                    } else {
                        valores.put(dni, 2300);
                    }
                    totalMedio += valores.get(dni);
                } else if (categ.equalsIgnoreCase("Avanzado")) {
                    if (edad > 18) {
                        valores.put(dni, 2800);
                    } else {
                        valores.put(dni, 0);
                        categoria.put(dni, "No le es permitido participar en la maratón");
                    }
                    totalAvanzado += valores.get(dni);
                }
            }
            totalCarrera = totalAvanzado + totalMedio + totalChico;
            System.out.println("                     ¿Qué categoría quiere ver?");
            System.out.println("-Chico\n-Medio\n-Avanzado\n-Desinscribir\n-Totales\n-Salir");
            opcion = sc.next();
            if (opcion.equalsIgnoreCase("Desinscribir")) {
                System.out.println("Ingrese el DNI del participante que quiere desinscribir");
                opcion = sc.next();
                persona.remove(opcion);
                inscripcion.remove(opcion);
                categoria.remove(opcion);
                edades.remove(opcion);
                System.out.println("Eliminado del listado");
            }
            if (opcion.equalsIgnoreCase("Totales")) {
                System.out.println("Totales: \n-Chico: " + totalChico + "\n-" + "Medio: " + totalMedio +
                        "\n-" + "Avanzado: " + totalAvanzado + "\n-" + "Total carrera: " + totalCarrera);
            } else {
                System.out.println("-------------------------------------------");
                for (Map.Entry<String, String> p : persona.entrySet()) {
                    String dni = p.getKey();
                    String categ = categoria.get(dni);
                    if (categ.equalsIgnoreCase(opcion)) {

                        String nombre = p.getValue();
                        String inscrip = inscripcion.get(dni);
                        Integer edad = edades.get(dni);
                        Integer valor = valores.get(dni);
                        System.out.println("Inscripcion: " + inscrip + "\n-DNI: " + dni + "\n-" + "Nombre: " + nombre +
                                "\n-" + "Categoria: " + categ + "\n-" + "Edad: " + edad + "\n-" + "Valor: " + valor);
                        System.out.println("-------------------------------------------");
                    }
                }
            }


        } while (!opcion.equalsIgnoreCase("Salir"));

    }
}