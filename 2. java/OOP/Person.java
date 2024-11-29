public class Person {
    String name;
    int age;
    String dni;
    double weight;
    double height;

    //Constructor sin parametros
    public Person(){

    }

    //Constrictor con nombre, edad y dni
    public Person(String name, int age, String dni){
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    //Constructor con todos  los parametros
    public Person(String name, int age, String dni, double height, double weight){
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.height = height;
        this.weight = weight;
    }

    public int cacularIMC(){
        double imc = this.weight*(Math.pow(this.height, 2));
        if (imc < 20){
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return (this.age >= 18) ? true : false;
    }

    @Override
    public String toString() {
        return "nombre: " + this.name +
                " edad: " + this.age +
                " DNI: " + this.dni +
                " peso: " + this.weight +
                " altura: " + this.height;
    }

    public static void main(String[] args) {
        Person mauricio = new Person();
        Person tere = new Person("maria teresa", 24, "adasd123axcaea");
        Person other = new Person("mauricio ballesteros", 29, "dadawdczxca", 67, 1.70);

        System.out.println("imc de " + other.name);

        int imc  = other.cacularIMC();

        switch (imc){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println(other.name + " es mayor de edad? ");

        System.out.println((other.esMayorDeEdad()) ? "Si" : "No");

        System.out.println("Datos de " + other.name);

        System.out.println(other);
    }
}
