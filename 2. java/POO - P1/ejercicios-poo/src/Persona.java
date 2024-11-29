public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona (String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double valor = this.peso/(this.altura * this.altura);
        if (valor < 20)
            return -1;
        if (valor > 25)
            return 1;
        return 0;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", DNI='" + dni + '\'' +
                ", Peso=" + peso +
                " kg, Altura=" + altura + " m";
    }
}