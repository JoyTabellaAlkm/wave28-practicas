public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        Persona persona2 = new Persona("Pepe", 33, "74621541");
        Persona persona3 = new Persona("Pepito", 20, "12641752", 23.40, 1.65);

        String esMayorDeEdad = persona3.esMayorDeEdad() ? "es mayor" : "no es mayor";
        String mensajeIMC = " Tipo de peso: ";
        switch (persona3.calcularIMC()) {
            case -1:
                mensajeIMC += "Bajo peso";
                break;
            case 0:
                mensajeIMC += "Peso saludable";
                break;
            case 1:
                mensajeIMC += "Sobrepeso";
        }
        System.out.println(persona3.toString() + " " + esMayorDeEdad + mensajeIMC);
    }
}

public class Persona {
    String nombre;
    int edad;
    String DNI;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona(String nombre, int edad, String DNI, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double valor = this.peso / (this.altura * this.altura);
        if (valor < 20)
            return -1;
        if (valor < 25)
            return 0;
        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String toString() {
        return "Nombre:" + this.nombre +
                " DNI: " + this.DNI +
                " Peso: " + this.peso +
                " Altura: " + this.altura;
    }
}