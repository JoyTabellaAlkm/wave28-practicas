public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        System.out.println(persona1.mostrarPersona());
        System.out.println("La primera persona: ");
        Persona persona2 = new Persona("Valen Sierra", 17, "1000133672");
        System.out.println(persona2.mostrarPersona());
        System.out.println("La segunda persona: ");
        Persona persona3 = new Persona("Daniel Romero", 29, "1032478349", 78.0, 1.78);
        System.out.println(persona3.mostrarPersona());
        System.out.println("La tercera persona: ");
        //Persona persona4 = new Persona("Karina");
        //System.out.println(persona4.mostrarPersona());
        //System.out.println("La primera persona: ");
        switch (persona3.calcularImc()) {
            case -1:
                System.out.println(persona3.nombre + " : " + "La persona tiene bajo peso");
                break;
            case 0:
                System.out.println(persona3.nombre + " : " + "La persona tiene peso saludable");
                break;
            default:
                System.out.println(persona3.nombre + " : " + "La persona tiene sobrepeso");
                break;
        }
        System.out.println(persona3.toString());
        System.out.print(persona2.nombre + " ");
        System.out.println(persona2.esMayorDeEdad() ? "es mayor de edad" : "es menor de edad");
    }
}

class Persona {
    //Las varibales de instancia
    public String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //El constructor sin parametros
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0.0;
        this.altura = 0.0;
    }

    //El contructor con nombre, edad y dni
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    //El consttructor con todos los atributos
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String mostrarPersona() {
        return "nombre: " + nombre + " edad: " + edad + " dni: " + dni + " peso: " + peso + " altura: " + altura;
    }

    public int calcularImc() {
        double imc = peso / (Math.pow(altura, 2));
        if (imc < 20) {
            return -1;
        } else {
            if (imc <= 25) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", peso=" + peso + ", altura=" + altura
                + "]";
    }
}



