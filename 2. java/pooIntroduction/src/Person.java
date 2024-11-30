public class Person {
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateBMI(){
        double bmi = weight / (Math.pow(height, 2));
        int result;
        if (bmi < 20){
            result = -1;
        } else if (bmi >= 20 && bmi <= 25) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }

    public boolean isOfLegalAge(){
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }
}
