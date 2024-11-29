public class Persona {

    // ATTRIBUTES
    private String name;
    private int age;
    private String uid;
    private float weight;
    private float height;

    // CONSTRUCTORS


    public Persona() {
    }

    public Persona(String name, int age, String uid) {
        this.name = name;
        this.age = age;
        this.uid = uid;
    }

    public Persona(String name, int age, String uid, float weight, float height) {
        this.name = name;
        this.age = age;
        this.uid = uid;
        this.weight = weight;
        this.height = height;
    }


    // METHOD

    //En la clase Persona implementaremos los siguientes métodos: cacularIMC(), la fórmula para calcularlo es:
    // peso/(altura^2) - (peso expresado en kg y altura en mts), si este cálculo devuelve un valor menor que 20,
    // la función debe retornar -1, si devuelve un número entre 20 y 25 inclusive para los dos valores, el método
    // debe retornar un 0, por último, si devuelve un número mayor que 25 debe retornar un 1.


    public int calcularIMC(){
        double result = this.weight/Math.pow(this.height, 2);
        if(result < 20){
            return -1;
        } else if (result <= 25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + this.name +
                "; Edad: " + this.age +
                "; DNI: " + this.uid
                + "; Peso: " + this.weight +
                "; Altura: " + this.height +
                ";";
    }

    // GETS & SETS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
