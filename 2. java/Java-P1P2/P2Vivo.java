// Este ejercicio es la parte 2 de Java de las clase en VIVO.
//
// Con el grupo llegamos a la siguiente 'estructura' para resolver
// el ejercicio que nos plantearon pero por falta de tiempo no 
// terminamos la implementación deseada.
//

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // region Ejercicio#1
        /*
         * double sueldoBase = 21000; //monto de ejemplo
         * String dni = "12345678"; //dni de ejemplo
         * double sueldoConAumento;
         * 
         * if (sueldoBase <= 20000) {
         * sueldoConAumento = sueldoBase + ((sueldoBase * 20) / 100);
         * }
         * else {
         * if (sueldoBase >= 20000 && sueldoBase <= 45000){
         * sueldoConAumento = sueldoBase + ((sueldoBase * 10) / 100);
         * }
         * else {
         * sueldoConAumento = sueldoBase + ((sueldoBase * 5) / 100);
         * }
         * }
         */

        // System.out.println ("El nuevo sueldo del empleado es de: " +
        // sueldoConAumento);
        // endregion

        // region Ejercicio#2
        /*
         * int serviciosCli[] = new int[7]; //vector de 7 posiciones con tipos de
         * servicios
         * serviciosCli[0] =1;
         * serviciosCli[1] =1;
         * serviciosCli[2] =2;
         * serviciosCli[3] =2;
         * serviciosCli[4] =2;
         * serviciosCli[5] =1;
         * serviciosCli[6] =2;
         * double totalFactura;
         * double precioFijo = 1500;
         * double servicioPatrullaje = 700;
         * for (int i=0;i <= (serviciosCli.length - 1);i++) {
         * if (serviciosCli[i] == 1) {
         * totalFactura = precioFijo;
         * System.out.println("El tipo de servicio es: " + serviciosCli[i]);
         * System.out.println("El monto de la factura es de: " + totalFactura);
         * } else {
         * totalFactura = precioFijo + servicioPatrullaje;
         * System.out.println("El tipo de servicio es: " + serviciosCli[i]);
         * System.out.println("El monto de la factura es de: " + totalFactura);
         * }
         * }
         */
        // endregions

        // region Ejercicio en VIVO
        // Variables
        boolean inscripcionCerrada = false;
        Scanner console = new Scanner(System.in);
        List<String> listaCategoria = new ArrayList<String>();
        Map<Integer, Map<String, Object>> participantes = new HashMap<Integer, Map<String, Object>>();

        while (!inscripcionCerrada) {
            System.out.println("Crear Categorias 1." +
                    " Registrar participante 2." +
                    " Mostrar todos los inscriptos 3." +
                    " Desinscribir participante 4." +
                    " Calcular monto total 5." +
                    " Salir 0.");
            int opciones = Integer.parseInt(console.nextLine());
            switch (opciones) {
                case 1:
                    // region Crear Categoria
                    Map<String, String> categoria = new HashMap<String, String>();
                    categoria.put("Circuito chico", " 2 km por selva y arroyos.");
                    categoria.put("Circuito medio", " 5 km por selva, arroyos y barro.");
                    categoria.put("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

                    // endregion
                    break;
                case 2:
                    // region Registrar participante

                    System.out.print("Ingrese el número de participante: ");
                    int numeroParticipante = Integer.parseInt(console.nextLine());

                    System.out.print("Ingrese DNI: ");
                    String dni = console.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = console.nextLine();

                    System.out.print("Ingrese apellido: ");
                    String apellido = console.nextLine();

                    System.out.print("Ingrese edad: ");
                    int edad = Integer.parseInt(console.nextLine());

                    System.out.print("Ingrese número de celular: ");
                    int celular = Integer.parseInt(console.nextLine());

                    System.out.print("Ingrese número de emergencia: ");
                    int numeroEmergencia = Integer.parseInt(console.nextLine());

                    System.out.print("Ingrese grupo sanguíneo: ");
                    String grupoSanguineo = console.nextLine();

                    // Crear un Map para almacenar los datos del participante
                    Map<String, Object> datosParticipante = new HashMap<String, Object>();
                    datosParticipante.put("DNI", dni);
                    datosParticipante.put("Nombre", nombre);
                    datosParticipante.put("Apellido", apellido);
                    datosParticipante.put("Edad", edad);
                    datosParticipante.put("Celular", celular);
                    datosParticipante.put("NumeroEmergencia", numeroEmergencia);
                    datosParticipante.put("GrupoSanguineo", grupoSanguineo);

                    // Almacenar el Map de datos en el Map de participantes
                    participantes.put(numeroParticipante, datosParticipante);
                    break;

                // endregion
                case 3:
                    // region Mostrar todos los inscriptos

                    // endregion
                    break;
                case 4:
                    // region Desinscribir participante

                    // endregion
                    break;
                case 5:
                    // region Calcular monto total

                    // endregion
                    break;
                default:
                    // region Salir

                    System.out.println("Seguro que quieres salir? true/false:");
                    inscripcionCerrada = Boolean.parseBoolean(console.nextLine());

                    // endregion
            }

        }

        // endregion

    }
}
