package Main;

import jdk.jfr.Category;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> category1 = createCategory("1", "Circuito chico", "2 km por selva y arroyos.");
        Map<Integer, String> category2 = createCategory("2", "Circuito medio", "5 km por selva, arroyos y barro.");
        Map<Integer, String> category3 = createCategory("3", "Circuito avanzado", "10 km por selva, arroyos, barro y escalada de piedra.");

        Map<Integer, String> participant1 = createAParticipant(
                "1",
                "40_444_444",
                "John",
                "Doe",
                "24",
                "1122334455",
                "999",
                "A+",
                "Circuito chico"
        );


        // Add one participant
        Map<Integer, Map<Integer, String>> registration1 = new HashMap<>();
        registration1.put(1, category1);
        registration1.put(2, participant1);

        Map<Integer, Map<Integer, Map<Integer, String>>> registrations = new HashMap<>();
        registrations.put(1, registration1);

        // Add some participants
        Map<Integer, String> participant2 = createAParticipant(
                "2",
                createRandomDNI(),
                "Jane",
                "Doe",
                createAge(),
                "1122334455",
                "999",
                "A+",
                "Circuito medio"
        );
        Map<Integer, Map<Integer, String>> registration2 = new HashMap<>();
        registration2.put(1, category2);
        registration2.put(2, participant2);
        registrations.put(2, registration2);

        Map<Integer, String> participant3 = createAParticipant(
                "3",
                createRandomDNI(),
                "Luke",
                "Skywalker",
                "33",
                "1122334455",
                "999",
                "A+",
                "Circuito avanzado"
        );
        Map<Integer, Map<Integer, String>> registration3 = new HashMap<>();
        registration3.put(1, category3);
        registration3.put(2, participant3);
        registrations.put(3, registration3);

        Map<Integer, String> participant4 = createAParticipant(
                "4",
                createRandomDNI(),
                "Leia",
                "Skywalker",
                "16",
                "1122334455",
                "999",
                "A+",
                "Circuito chico"
        );
        Map<Integer, Map<Integer, String>> registration4 = new HashMap<>();
        registration4.put(1, category1);
        registration4.put(2, participant4);
        registrations.put(4, registration4);

        getTotalCost(registrations);

        registrations.remove(4);
        getTotalCost(registrations);

    }

    public static Map<Integer, String> createCategory(String id, String name, String description) {
        Map<Integer, String> category = new HashMap<>();
        category.put(1, id);
        category.put(2, name);
        category.put(3, description);

        return category;
    }

    public static String createRandomDNI() {
        int min = 30_000_000;
        int max = 45_000_000;
        Random random = new Random();

        return Integer.toString(random.nextInt(max - min + 1) + min);
    }

    public static String createAge() {
        int min = 15;
        int max = 45;
        Random random = new Random();

        return Integer.toString(random.nextInt(max - min + 1) + min);
    }

    public static Map<Integer, String> createAParticipant(String id, String dni, String name, String surname, String age, String cellphone, String emergencyNumber, String bloodType, String categoryName) {
        Map<Integer, String> person = new HashMap<>();
        person.put(1, id);
        person.put(2, dni);
        person.put(3, name);
        person.put(4, surname);
        person.put(5, age);
        person.put(6, cellphone);
        person.put(7, emergencyNumber);
        person.put(8, bloodType);
        person.put(9, getTotalCost(categoryName, age));

        return person;
    }

    public static String getTotalCost(String categoryName, String age) {
        int cost = 0;
        int ageInteger = Integer.parseInt(age);
        if(ageInteger < 18) {
            if(categoryName.equalsIgnoreCase("Circuito chico")) {
                cost = 1300;
            }
            else {
                cost = 2000;
            }
        }
        else {
            if(categoryName.equalsIgnoreCase("Circuito chico")) {
                cost = 1500;
            }
            else if(categoryName.equalsIgnoreCase("Circuito medio")) {
                cost = 2300;
            }
            else {
                cost = 2800;
            }
        }

        return Integer.toString(cost);
    }

    public static int getCostByCategory(String categoryName, Map<Integer, Map<Integer, Map<Integer, String>>> registrations) {
        int costByCategory = 0;
        for(Map.Entry<Integer, Map<Integer, Map<Integer, String>>> entry: registrations.entrySet()) {
            if(entry.getValue().get(1).get(2).equalsIgnoreCase(categoryName)) {
                costByCategory += Integer.parseInt(entry.getValue().get(2).get(9));
            }
        }

        System.out.println("Cost by category " + categoryName + " is " + costByCategory);
        return costByCategory;
    }

    public static int getTotalCost(Map<Integer, Map<Integer, Map<Integer, String>>> registrations) {
        int costCircuitoChico = getCostByCategory("Circuito chico", registrations);
        int costCircuitoMediano = getCostByCategory("Circuito medio", registrations);
        int costCircuitoAvanzado = getCostByCategory("Circuito avanzado", registrations);

        System.out.println("Total cost is " + (costCircuitoChico + costCircuitoMediano + costCircuitoAvanzado));

        return costCircuitoAvanzado + costCircuitoChico + costCircuitoMediano;
    }
}
