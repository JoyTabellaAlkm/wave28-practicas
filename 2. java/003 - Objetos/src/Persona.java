public class Persona {
    String dni;
    String nombre;
    int edad;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String dni, String nombre, int edad, double peso, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = (this.peso/(this.altura*this.altura));
        if(imc<20){
            return -1;
        } else if(imc <= 25 && imc >= 20){
            return 0;
        }
        return 1;
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
