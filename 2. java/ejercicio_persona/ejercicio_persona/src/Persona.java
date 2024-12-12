public class Persona {
    private String nombre;
    private String edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(String nombre, String edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, String edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }

    double cacularIMC() {
        double medida = peso / (altura * altura);

        if (medida < 20) return -1;
        if (medida <= 25) return 0;
        return 1;
    }

    boolean esMayorDeEdad() {
        return Integer.parseInt(edad) >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
