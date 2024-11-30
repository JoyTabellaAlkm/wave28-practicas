
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Juan", 25, "1235421");
        Person person3 = new Person("David", 35, "8725436", 77, 1.81);

        //Person person4 = new Person("Carlos", 15); Genera un error ya que no hay constructor definido con estos parámetros

        int weightLevel = person3.calculateBMI();

        if (weightLevel == -1){
            System.out.printf("%s tiene un nivel de peso bajo", person3.getName());
        } else if (weightLevel == 0) {
            System.out.printf("%s tiene un nivel de peso saludable", person3.getName());
        } else {
            System.out.printf("%s tiene sobrepeso", person3.getName());
        }

        String message = person3.isOfLegalAge() ? "es mayor de edad" : "es menor de edad";
        System.out.printf("\n%s %s",person3.getName(), message);
    }
}