package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Object> categories = createCategories();
        Map<Integer, Object[]> registrations = new HashMap<>();

        // Add one participant
        registrations.put(1, new Object[]{
            new HashMap<Integer, Object[]>() {{ put(
                40_444_444,
                new Object[]{
                    new Object[]
                        {
                            "John",
                            "Doe",
                            24,
                            "1122334455",
                            "999",
                            "A+"
                        },
                    categories.get(1),
                    1500
                }
            );
            }}
        });

        // Add some participants
        for(int i = 1; i < 4; i++) {
            Object person;
            int dni = createRandomDNI();
            int age = createAge();
            String name = i % 2 == 0 ? "Jane" + i: "John" + 1;
            String surname = "Doe";
            person = new Object[] {
                    dni,
                    name,
                    surname,
                    age,
                    "1122334455",
                    "999",
                    "A+"
            };
            double cost = 0;

            switch (i) {
                case 1:
                    if(age < 18) {
                        cost = 1300;
                    }
                    else {
                        cost = 1500;
                    }
                case 2:
                    if(age < 18) {
                        cost = 2000;
                    }
                    else {
                        cost = 2300;
                    }
                case 3:
                    while(age < 18) {
                        age = createAge();
                    }
                    cost = 2800;
            }
            Object category = categories.get(i);
            double finalCost = cost;
            registrations.put(i, new Object[]{
                new HashMap<Integer, Object[]>() {{ put(
                    dni,
                    new Object[]{
                        person,
                        category,
                        finalCost
                    }
                );
                }}
            });

        }


    }

    public static Map<Integer, Object> createCategories() {
        Map<Integer, Object> categories = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    categories.put(i + 1, new Object[]{"Circuito chico", "2 km por selva y arroyos."});
                    break;
                case 1:
                    categories.put(i + 1, new Object[]{"Circuito medio", "5 km por selva, arroyos y barro."});
                    break;
                case 2:
                    categories.put(i + 1, new Object[]{"Circuito avanzado", "10 km por selva, arroyos, barro y escalada de piedra."});
                    break;
            }
        }

        return categories;
    }

    public static int createRandomDNI() {
        int min = 30_000_000;
        int max = 45_000_000;
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }

    public static int createAge() {
        int min = 15;
        int max = 45;
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}
