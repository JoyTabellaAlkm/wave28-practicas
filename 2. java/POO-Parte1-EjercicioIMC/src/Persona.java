public class Persona {
    String nombre;
    String dni;
    int edad;
    double altura;
    double peso;

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double altura, double peso) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIMC() {
        double imc = this.peso / (this.altura * this.altura);
        if (imc < 20) {
            return -1;
        }
        else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}