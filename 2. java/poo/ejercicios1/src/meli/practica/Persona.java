package meli.practicas;

public class Persona {
    //Las varibales de instancia
    public String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //El constructor sin parametros
    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0.0;
        this.altura = 0.0;
    }

    //El contructor con nombre, edad y dni
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    //El consttructor con todos los atributos
    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String mostrarPersona(){
        return "nombre: " + nombre + " edad: " + edad + " dni: " + dni + " peso: " + peso + " altura: " + altura;
    }

    public int calcularImc(){
        
        double imc = peso/(Math.pow(altura,2));
        if (imc <20) {
            return -1;
        } else {
            if (imc <=25){
                return 0;
            } else {
                return 1;
            }
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", peso=" + peso + ", altura=" + altura
                + "]";
    }
    
    
}
