import Entities.*;

public class Main {
    public static void main(String[] args) {


        System.out.println("====================");
        System.out.println("### USING CLASS1 ###");
        System.out.println("====================");

        Class1 entity1 = new Class1(4, 2);
        for(int i=0; i<10; i++){
            System.out.println("Next value: " + entity1.returnNextValue());
        }

        System.out.println("\n-- New starting value: 1 --\n");
        entity1.setStartingValue(1);

        for(int i=0; i<10; i++){
            System.out.println("Next value: " + entity1.returnNextValue());
        }

        System.out.println("====================");
        System.out.println("### USING CLASS2 ###");
        System.out.println("====================");

        Class2 entity2 = new Class2(1, 5);

        for(int i=0; i<5; i++){
            System.out.println("Next value: " + entity2.returnNextValue());
        }

        System.out.println("\n-- Restarting series -- \n");
        entity2.resetSeries();

        for(int i=0; i<5; i++){
            System.out.println("Next value: " + entity2.returnNextValue());
        }



    }
}
