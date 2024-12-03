public class Main_Animal {
    public static void main(String[] args) {
        Perro perro1 = new Perro();
  
        comerAnimal(perro1);
    }
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        } else {
            System.out.println("Este animal no tiene definido qué comer.");
        }
    }
    
}
