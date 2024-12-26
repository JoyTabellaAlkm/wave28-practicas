public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, double peso, int edad, String dni, double altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
    }
    
    public int cacularIMC(){
        double imc = peso /( Math.pow(altura, 2));
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "DNI: " + dni + "\n" +
                "Edad: " + edad + "\n" +
                "Peso: " + peso + " kg\n" +
                "Altura: " + altura + " m\n" +
                "Mayor de edad: " + (esMayorDeEdad() ? "Sí" : "No") + "\n" +
                "IMC: " + cacularIMC();
    }
}
