import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String,String> categorias = new HashMap<>();

//número de inscripción, una categoría, un participante y el monto a abonar por el participante.
        ArrayList<Map<String,String>> inscripciones = new ArrayList<>();

//número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.  
        ArrayList<Map<String,String>> participantes = new ArrayList<>();

        //PUNTO A)
        categorias.put("Circuito chico", " 2 km por selva y arroyos.");
        categorias.put("Circuito medio", " 5 km por selva, arroyos y barro.");
        categorias.put("Circuito avanzado", " 10 km por selva, arroyos, barro y escalada en piedra.");

        //PUNTO B) creacion de participantes
        Map<String, String> participante1 = Map.of(
            "dni","10101010",
            "nombre","Juanito",
            "apellido", "Perez", 
            "edad","16",
            "celular","3102022020",
            "numero de emergencia","3102023030",
            "grupo sanguineo","O+");

        Map<String, String> participante2 = Map.of(
            "dni","20101010",
            "nombre","Maria",
            "apellido", "Perez", 
            "edad","20",
            "celular","3102022020",
            "numero de emergencia","3102023030",
            "grupo sanguineo","O+");

        Map<String, String> participante3 = Map.of(
            "dni","30101010",
            "nombre","Jose",
            "apellido", "Perez", 
            "edad","17",
            "celular","3102022020",
            "numero de emergencia","3102023030",
            "grupo sanguineo","O+");

        Map<String, String> participante4= Map.of(
            "dni","14101010",
            "nombre","Pablo",
            "apellido", "Perez", 
            "edad","30",
            "celular","3102022020",
            "numero de emergencia","3102023030",
            "grupo sanguineo","O+");

        Map<String, String> participante5= Map.of(
            "dni","15101010",
            "nombre","Mario",
            "apellido", "Perez", 
            "edad","30",
            "celular","3102022020",
            "numero de emergencia","3102023030",
            "grupo sanguineo","O+");

        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);
        participantes.add(participante4);
        participantes.add(participante5);

        //PUNTO B) inscripcion de participantes
        // el monto se calcula con la funcion inscripcion linea 
        Map<String,String>inscrip = inscripcion("Circuito avanzado", "0", participantes.get(0).get("edad"));
        Map<String,String>inscrip1 = inscripcion("Circuito chico", "1", participantes.get(1).get("edad"));
        Map<String,String>inscrip2 = inscripcion("Circuito medio", "2", participantes.get(2).get("edad"));
        Map<String,String>inscrip3 = inscripcion("Circuito avanzado", "3", participantes.get(3).get("edad"));
        Map<String,String>inscrip4 = inscripcion("Circuito avanzado", "4", participantes.get(4).get("edad"));


        //PUNTO C)
        //Simulación de un participante que no se puede inscribir avanzado por ser menor de edad
        if(inscrip==null){
            System.out.println("\n No se puede inscribir participante a esta categoria por ser menor de edad");
        }else{
            inscripciones.add(inscrip);
            System.out.println(inscripciones.get(0));
        }

        //inscripciones normales
        inscripciones.add(inscrip1);
        inscripciones.add(inscrip2);
        inscripciones.add(inscrip3);
        inscripciones.add(inscrip4);


        //PUNTO D)
        ver_Participantes("Circuito avanzado",inscripciones, participantes);

        //PUNTO E)
        String participante_a_desinscribir="4";
        int indice_inscripcion_de_participante = desinscribir_Participantes(participante_a_desinscribir, inscripciones);
        String categoria_participante =  inscripciones.get(indice_inscripcion_de_participante).get("categoria");
        inscripciones.remove(indice_inscripcion_de_participante);
        ver_Participantes(categoria_participante,inscripciones, participantes);


        //PUNTO F)
        //para probar que se esté sumando correctamente se vuelve a inscribir al parcipante eliminado
        inscripciones.add(inscrip4);

        ver_Montos(categorias,inscripciones);

        //System.out.println(categorias.get("Circuito chico"));
    }


    //Funcion para crear una inscripción valida de devolver un objeto inscripción
    public static Map<String,String> inscripcion(String categoria, String participante, String edad) {
        //número de inscripción, una categoría, un participante y el monto a abonar por el participante.
        String valor ="";
        String[] datos_inscripciones = {"categoria","participante","monto"};
        //- Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
        //- Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
        //- Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

        switch (categoria) {
            case "Circuito chico":
                if(Integer.parseInt(edad)<18){
                    valor ="1300";
                }else{
                    valor = "1500";
                }
                break;
            case "Circuito medio":
                if(Integer.parseInt(edad)<18){
                    valor ="2000";
                }else{
                    valor = "2300";
                }
                break;
            case "Circuito avanzado":
                if(Integer.parseInt(edad)<18){
                    return null;
                }else{
                    valor = "2800";
                }
                break;
        }
        Map<String,String> inscrip = Map.of(
            datos_inscripciones[0], categoria,
            datos_inscripciones[1], participante,
            datos_inscripciones[2], valor
        );

        return inscrip;
    }


    //Funcion para crear participante
    public static Map<String,String> crear_Participante() {
        String[] datos_personas = {"dni","nombre","apellido","edad","celular","numero de emergencia","grupo sanguineo"};   
        Map<String,String> persona = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String dato = "";
        int i = 0;
        do{
            System.out.println("Ingrese el "+datos_personas[0]+" del participante");
            dato = scanner.nextLine();
            persona.put(datos_personas[i],dato);

        }while(i<datos_personas.length);

        scanner.close();
        return persona;
    }

    //Funcion para ver participantes inscritos a una misma categoria
    public static void ver_Participantes(String categoria, ArrayList<Map<String,String>>inscripciones, ArrayList<Map<String,String>>participantes) {
        System.out.println("\n Los participantes inscritos a la categoria "+categoria+" son:");
        for (int i = 0; i < inscripciones.size(); i++) {
            if(inscripciones.get(i).get("categoria").equals(categoria)){
                System.out.println("Numero de inscripción: " + i + " " +
                participantes.get(Integer.parseInt(inscripciones.get(i).get("participante"))));
            }
        }
    }

    public static int desinscribir_Participantes(String participante, ArrayList<Map<String,String>>inscripciones) {
        for (int i = 0; i < inscripciones.size(); i++) {
            if(inscripciones.get(i).get("participante").equals(participante)){
                return i;
            }
        }
        return -1;
    }

    public static void ver_Montos(Map<String,String> categorias, ArrayList<Map<String,String>>inscripciones){
        System.out.println("\n RESUMEN DE RECAUDOS =>");

        List<String> categoriasList = new ArrayList<>(categorias.keySet());
        double[] recaudos = new double[categoriasList.size()+1];
        for (int i = 0; i < inscripciones.size(); i++) {
            int index =  categoriasList.indexOf(inscripciones.get(i).get("categoria"));
            double monto = Double.parseDouble(inscripciones.get(i).get("monto"));
            recaudos[index] += monto;
            recaudos[recaudos.length-1] += monto;
        }

        for (int i = 0; i < categoriasList.size(); i++) {
            System.out.println("La categoría " + categoriasList.get(i) + " recaudo: $" + recaudos[i]);
        }
        System.out.println("El total recaudado fue de: $"+ recaudos[recaudos.length-1]+ "\n");

    }


}
