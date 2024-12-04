package poo.p1.ejercicios_sincronicos;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        if (peso <= 0 && altura <= 0) {
            return -2;
        }
        double imc = this.peso / (Math.pow(this.altura, 2));
        if (imc < 20) {
            return -1;
        } else if (imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public void imprimirResultadoIMC() {
        switch (this.calcularIMC()) {
            case -1 -> System.out.println("El nivel de peso es: BAJO");
            case 0 -> System.out.println("El nivel de peso es: SALUDABLE");
            case 1 -> System.out.println("El nivel de peso es: SOBREPESO");
            default -> System.out.println("No es posible calcular IMC");
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}