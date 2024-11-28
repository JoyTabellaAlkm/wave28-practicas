import java.util.*;

public class Two {
    public static void main(String[] args) {
        //region CATEGORIES
        //Se crean las 3 categorias de la competencia
        HashMap<Integer, Map<String, String>> categories = new HashMap<>();
        categories.put(1, Map.of(
                "name", "Circuito chico",
                "description", "Menores de 18 años $1300. Mayores de 18 años $1500.")
        );
        categories.put(2, Map.of(
                "name", "Circuito medio",
                "description", "Menores de 18 años $2000. Mayores de 18 años $2300.")
        );
        categories.put(3, Map.of(
                "name", "Circuito Avanzado",
                "description", "No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800."));
        //endregion

        //region VARIABLES
        Scanner console = new Scanner(System.in);
        Random random = new Random();
        boolean is_active = true;
        //endregion

        //region PARTICIPANTS
        //se generan aleatoriamente los participantes de las competencias
        HashMap<Integer, Map<String, String>> participants = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> participant = new HashMap<>();
            participant.put("dni", "" + (random.nextInt(1000)+1));
            participant.put("name", generateRandom());
            participant.put("lastname", generateRandom());
            int category = random.nextInt(3)+1;
            participant.put("categoryId", "" + category);
            int age = (category == 3) ? 18 : random.nextInt(60)+1;
            participant.put("age", "" + age);
            participant.put("phone", "" + (random.nextInt(1000)+1));
            participant.put("alertNumber", "" + (random.nextInt(1000)+1));
            participant.put("bloodType", "O+");
            participants.put(i+1, participant);
        }
        //endregion

        do {
            System.out.println("""
                    Ingrese una opcion:
                    1. Crear nuevo participante.
                    2. Inscritos por categoria.
                    3. Informacion de un participante.
                    4. Calcular el monto total recaudado por cada categoría.
                    5. Calcular el monto total recaudado.
                    6. Salir.""");
            String option = console.nextLine();
            switch (option){
                case "1":{
                    HashMap<String, String> participant = new HashMap<>();
                    System.out.println("Ingresa el dni");
                    participant.put("dni", console.nextLine());
                    System.out.println("Ingresa el nombre");
                    participant.put("name", console.nextLine());
                    System.out.println("Ingresa el apellido");
                    participant.put("lastname", console.nextLine());
                    System.out.println("Ingresa la edad");
                    participant.put("age", console.nextLine());
                    System.out.println("Ingresa el telefono");
                    participant.put("phone", console.nextLine());
                    System.out.println("Ingresa el numero de emergencia");
                    participant.put("alertNumber", console.nextLine());
                    System.out.println("Ingresa el tipo de sangre");
                    participant.put("bloodType", console.nextLine());
                    System.out.println("Ingresa el id de la categoria.");
                    participant.put("categoryId", console.nextLine());
                    participants.put(participants.size()+1, participant);
                }
                break;
                case "2":{
                    System.out.println("""
                            Escoge el id de la cartegoria que quieres revisar: 
                            1. Circuito chico.
                            2. Circuito medio.
                            3. Circuito Avanzado""");
                    String category = console.nextLine();
                    for (Map.Entry<Integer, Map<String, String>> entrada : participants.entrySet()){
                        Map<String, String> person = entrada.getValue();
                        if (person.get("categoryId").equals(category)){
                            System.out.println(person);
                        }
                    }
                }
                break;
                case "3":{
                    System.out.println("Ingresa el Id del participante:");
                    System.out.println(participants.get(Integer.parseInt(console.nextLine())));
                }
                break;
                case "4":{
                    System.out.println("""
                            Escoge el id de la cartegoria que quieres revisar: 
                            1. Circuito chico.
                            2. Circuito medio.
                            3. Circuito Avanzado""");
                    String categoryId = console.nextLine();
                    int total = 0;
                    for (Map.Entry<Integer, Map<String, String>> entrada : participants.entrySet()){
                        Map<String, String> person = entrada.getValue();
                        if (person.get("categoryId").equals(categoryId)){
                            if (categoryId.equals("1")){
                                total += (Integer.parseInt(person.get("age")) < 18) ? 1300 : 1500;
                            } else if (categoryId.equals("2")) {
                                total += (Integer.parseInt(person.get("age")) < 18) ? 2000 : 2300;
                            }
                            else {
                                total += 1800;
                            }
                        }
                    }
                    Map<String, String> category = categories.get(Integer.parseInt(categoryId));
                    System.out.println("El valor de la categoria " + category.get("name") + " es " + total);
                }
                break;
                case "5":{
                    int total = 0;
                    for (Map.Entry<Integer, Map<String, String>> entrada : participants.entrySet()){
                        Map<String, String> person = entrada.getValue();
                        if (person.get("categoryId").equals("1")){
                            total += (Integer.parseInt(person.get("age")) < 18) ? 1300 : 1500;
                        } else if (person.get("categoryId").equals("2")) {
                            total += (Integer.parseInt(person.get("age")) < 18) ? 2000 : 2300;
                        }
                        else {
                            total += 1800;
                        }
                    }
                    System.out.println("El valor total es " + total);
                }
                break;
                case "6":{
                    System.out.println("Adios");
                    is_active = false;
                }
                default:{
                    System.out.println("Ingresa un valor valido");
                }
                break;
            }
            System.out.println("--------------------------------------");
        }while (is_active);
        //endregion

    }

    static String generateRandom(){
        //crea una serie de palabras random
        Random rand = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            int randIndex = rand.nextInt(chars.length());
            res.append(chars.charAt(randIndex));
        }
        return res.toString();
    }
}
