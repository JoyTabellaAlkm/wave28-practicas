package bootcamp;

public class Persona {
    String nombre;
    int edad;
    String dni;
    Double altura;
    Double peso;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, Double altura, Double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC() {
        Double indice = peso / (altura * altura);
        if (indice < 20) {
            return -1;
        } else if (indice >= 20 && indice <= 25) {
            return 0;
        } else return 1;
    }

    public Boolean esMayorDeEdad() {
        return edad > 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
