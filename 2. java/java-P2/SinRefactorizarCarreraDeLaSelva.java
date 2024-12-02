import java.util.*;

public class SinRefactorizarCarreraDeLaSelva{

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

            Map<String, Object> participante = new HashMap<>();
            participante.put("id", 9283);
            participante.put("idCat", cat1);
            participante.put("nombre", "Pepe");
            participante.put("dni", "23677651");
            participante.put("apellido", "Perez");
            participante.put("edad", 21);
            participante.put("celular", "3218989899");
            participante.put("numeroDeEmergencia", "3218989899");
            participante.put("grupoSanguineo", "+O");

            Map<String, Object> participante1 = new HashMap<>();
            participante1.put("id", 223);
            participante1.put("idCat", cat2);
            participante1.put("nombre", "Maria");
            participante1.put("dni", "2367217651");
            participante1.put("apellido", "Perez");
            participante1.put("edad", 20);
            participante1.put("celular", "3218989899");
            participante1.put("numeroDeEmergencia", "3218989899");
            participante1.put("grupoSanguineo", "+O");

            Map<String, Object> participante2 = new HashMap<>();
            participante2.put("id", 323);
            participante2.put("idCat", cat3);
            participante2.put("nombre", "Ana");
            participante2.put("dni", "236721651");
            participante2.put("apellido", "Perez");
            participante2.put("edad", 12);
            participante2.put("celular", "3218989899");
            participante2.put("numeroDeEmergencia", "3218989899");
            participante2.put("grupoSanguineo", "+O");

            Map<String, Object> participante3 = new HashMap<>();
            participante3.put("id", 100);
            participante3.put("idCat", cat3);
            participante3.put("nombre", "Dominga");
            participante3.put("dni", "23621651");
            participante3.put("apellido", "Sanchez");
            participante3.put("edad", 30);
            participante3.put("celular", "3218989899");
            participante3.put("numeroDeEmergencia", "3218989899");
            participante3.put("grupoSanguineo", "+O");

            Map<String, Object> participante4 = new HashMap<>();
            participante4.put("id", 212);
            participante4.put("idCat", cat3);
            participante4.put("nombre", "Mari");
            participante4.put("dni", "23621651");
            participante4.put("apellido", "Gonzalez");
            participante4.put("edad", 19);
            participante4.put("celular", "3218989899");
            participante4.put("numeroDeEmergencia", "3218989899");
            participante4.put("grupoSanguineo", "+O");

            /*Inscripciones*/

            Map<String, Object> inscripcion = new HashMap<>();
            inscripcion.put("id", 1);
            inscripcion.put("idCat", cat1);
            inscripcion.put("idPar", participante);

            Map<String, Object> inscripcion1 = new HashMap<>();
            inscripcion1.put("id", 2);
            inscripcion1.put("idCat", cat2);
            inscripcion1.put("idPar", participante1);

            Map<String, Object> inscripcion2 = new HashMap<>();
            inscripcion2.put("id", 2);
            inscripcion2.put("idCat", cat3);
            inscripcion2.put("idPar", participante2);

            Map<String, Object> inscripcion3 = new HashMap<>();
            inscripcion3.put("id", 3);
            inscripcion3.put("idCat", cat3);
            inscripcion3.put("idPar", participante3);

            Map<String, Object> inscripcion4 = new HashMap<>();
            inscripcion4.put("id", 4);
            inscripcion4.put("idCat", cat3);
            inscripcion4.put("idPar", participante4);

            List<Map<String, Object>> allInscriptos = new ArrayList<>();
            allInscriptos.add(inscripcion);
            allInscriptos.add(inscripcion1);
            allInscriptos.add(inscripcion2);
            allInscriptos.add(inscripcion3);
            allInscriptos.add(inscripcion4);


            double totalCat1 = 0;
            double totalCat2 = 0;
            double totalCat3 = 0;

            String messageTotalCat1 = "";
            String messageTotalCat2 = "";
            String messageTotalCat3 = "";

            for (Map<String,Object> inscritos : allInscriptos){

                Map<String, Object> categoria = (Map<String, Object>) inscritos.get("idCat");
                Map<String, Object> atleta    = (Map<String, Object>) inscritos.get("idPar");

                double totalAbonar = calcularCostoAbonar((int)categoria.get("id"), (int)atleta.get("edad"));
                inscritos.put("abonar", totalAbonar);

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

                if((int)categoria.get("id") == 1){
                    totalCat1 +=  totalAbonar;
                    messageTotalCat1 = "Total recaudado en la categoria " + datosDeLaCategoria + ": $" + totalCat1;
                }else if ((int)categoria.get("id") == 1){
                    totalCat2 +=  totalAbonar;
                    messageTotalCat2 = "Total recaudado en la categoria " + datosDeLaCategoria + ": $" + totalCat2;
                }else{
                    totalCat3 +=  totalAbonar;
                    messageTotalCat3 = "Total recaudado en la categoria " + datosDeLaCategoria + ": $" + totalCat3;
                }

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

            System.out.println(messageTotalCat1);
            System.out.println(messageTotalCat2);
            System.out.println(messageTotalCat3);

            System.out.println("Total recaudado para todas las categorias: $" + (totalCat1+ totalCat2+totalCat3));

            allInscriptos.removeLast();

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
