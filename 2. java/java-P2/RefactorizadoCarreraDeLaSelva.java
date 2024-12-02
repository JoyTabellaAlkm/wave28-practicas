import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactorizadoCarreraDeLaSelva {

        public static void main(String[] args){

            /*
                Categorias
            */

            Map<String, Object> cat1 = new HashMap<>();
            cat1.put("id", 1);
            cat1.put("nombre", "Circuito chico");
            cat1.put("descripcion", "2 km por selva y arroyos");

            Map<String, Object> cat2 = new HashMap<>();
            cat2.put("id", 2);
            cat2.put("nombre", "Circuito medio");
            cat2.put("descripcion", "5 km por selva, arroyos y barro");

            Map<String, Object> cat3 = new HashMap<>();
            cat3.put("id", 3);
            cat3.put("nombre", "Circuito avanzado");
            cat3.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");

            /*
                 Participantes
            */

            List<Map<String, Object>> participantes = new ArrayList<>();
            participantes.add(crearParticipante(9283, "2300000",cat1, "Pepe", "Perez", 21, "3218900000", "3219000000", "+O" ));
            participantes.add(crearParticipante(223,"2300000",  cat2, "Maria", "Perez", 20, "3218900000", "3219000000", "+O"));
            participantes.add(crearParticipante(323, "2300000", cat3, "Ana", "Perez", 12, "3218900000", "3219000000", "+O"));
            participantes.add(crearParticipante(100, "2300000", cat3, "Dominga", "Sanchez", 30, "3218900000", "3219000000", "+O"));
            participantes.add(crearParticipante(212, "2300000",  cat3, "Mari", "Gonzalez", 19, "3218900000", "3219000000", "+O"));

            /*
                Inscripciones
            */

            List< Map<String, Object> > allInscriptos = new ArrayList<>();
            for (Map<String, Object> participante : participantes) {
                Map<String, Object> inscripcion = new HashMap<>();
                inscripcion.put("id", allInscriptos.size() + 1);
                inscripcion.put("idCat", participante.get("idCat"));
                inscripcion.put("idPar", participante);
                allInscriptos.add(inscripcion);
            }

            double totalCat1 = 0;
            double totalCat2 = 0;
            double totalCat3 = 0;

            for (Map<String,Object> inscritos : allInscriptos){

                Map<String, Object> categoria = (Map<String, Object>) inscritos.get("idCat");
                Map<String, Object> atleta    = (Map<String, Object>) inscritos.get("idPar");

                double totalAbonar = calcularCostoAbonar((int)categoria.get("id"), (int)atleta.get("edad"));

                mostrarDatosDeLosParticipante (categoria, atleta, totalAbonar );

                inscritos.put("abonar", totalAbonar);

                switch ((int) categoria.get("id")){
                    case 1: totalCat1 += totalAbonar;break;
                    case 2: totalCat2 += totalAbonar;break;
                    case 3: totalCat3 += totalAbonar;break;
                }

                mostrarDatosDeLosParticipante(categoria, atleta, totalAbonar);
            }

            System.out.println("Total recaudado en la categoria Circuito chico: $" + totalCat1);
            System.out.println("Total recaudado en la categoria Circuito medio: $" + totalCat2);
            System.out.println("Total recaudado en la categoria Circuito avanzado: $" + totalCat3);
            System.out.println("Total recaudado para todas las categorias: $" + (totalCat1+ totalCat2+totalCat3));

            allInscriptos.removeLast();

        }

        public static Map<String, Object>  crearParticipante(int id, String dni, Map<String, Object> categoria, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo){
            Map<String, Object> participante = new HashMap<>();
            participante.put("id", id);
            participante.put("idCat", categoria);
            participante.put("nombre", nombre);
            participante.put("dni", dni);
            participante.put("apellido", apellido);
            participante.put("edad", edad);
            participante.put("celular", celular);
            participante.put("numeroDeEmergencia", numeroDeEmergencia);
            participante.put("grupoSanguineo", grupoSanguineo);
            return participante;
        }

        public static void mostrarDatosDeLosParticipante (Map<String, Object> categoria, Map<String, Object> atleta, double totalAbonar ){
            String nombre = (String) categoria.get("nombre");
            String descripcion = (String) categoria.get("descripcion");
            String datosDeLaCategoria = nombre + " " + descripcion;

            String nombreA = (String) atleta.get("nombre");
            String dniA = (String) atleta.get("dni");
            String apellidoA = (String) atleta.get("apellido");
            int    edadA = (int) atleta.get("edad");
            String celularA = (String) atleta.get("celular");
            String numeroDeEmergenciaA = (String) atleta.get("numeroDeEmergencia");
            String grupoSanguineoA = (String) atleta.get("grupoSanguineo");

            System.out.printf(
                    "\n**************************************************\n" +
                            "DNI: %s\n" +
                            "NOMBRE: %s\n" +
                            "APELLIDO: %s\n" +
                            "EDAD: %d\n" +
                            "CELULAR: %s\n" +
                            "NUMERO DE EMERGENCIA: %s\n" +
                            "GRUPO SANGUINEO: %s\n" +
                            "CATEGORIA: %s\n" +
                            "TOTAL ABONADO:  %,.2f\n" +
                            "**************************************************\n",
                    dniA, nombreA, apellidoA, edadA,celularA,numeroDeEmergenciaA,grupoSanguineoA, datosDeLaCategoria, totalAbonar);
        }


        public static double calcularCostoAbonar(int idCat, int edad){
            double total = 0;
            switch (idCat){
                case 1:
                    total = (edad <= 18) ? 1300 : 1500;
                    break;
                case 2:
                    total = (edad <= 18) ? 2000 : 2300;
                    break;
                case 3:
                    total = (edad <= 18) ? 0 : 2800;
                    break;
                default:
                    total = 0;
                    break;
            }
            return  total;
        }
}