public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Palmiro", 88, "12345678A");
        Persona persona3 = new Persona("Mateo", 24, "87654321B", 80, 1.80);
        Persona persona4 = new Persona("Tomasito", 14, "87654321B", 135, 1.40);

        System.out.println(String.format("%-10s %-5s %-10s %-6s %-6s %-15s %-15s",
         "Nombre", "Edad", "DNI", "Peso", "Altura", "Estado IMC", "Edad"));        
        System.out.println("------------------------------------------------------------------------");
        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);
        System.out.println(persona4);
    }
}

class Persona {
    // Atributos ---------------------------------------------------------------
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    // Constructores -----------------------------------------------------------
    public Persona() {}
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;}
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;}

    // Métodos -----------------------------------------------------------------
    public int calcularIMC() {
        double imc = peso / (Math.pow(altura, 2));
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;}
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // toString ---------------------------------------------------------------
    @Override
    public String toString() {
        String estadoIMC;
        int imc = calcularIMC();
        switch (imc) {
            case -1:
                estadoIMC = "Bajo peso";
                break;
            case 0:
                estadoIMC = "Peso saludable";
                break;
            case 1:
                estadoIMC = "Sobrepeso";
                break;
            default:
                estadoIMC = "Error IMC";
                break;
        }
        String estadoEdad;
        if (esMayorDeEdad()) {
            estadoEdad = "Mayor de edad";
        } else {
            estadoEdad = "No mayor de edad";
        }
        return String.format("%-10s %-5d %-10s %-6.2f %-6.2f %-15s %-15s", 
        nombre, edad, dni, peso, altura, estadoIMC, estadoEdad);
    }

}