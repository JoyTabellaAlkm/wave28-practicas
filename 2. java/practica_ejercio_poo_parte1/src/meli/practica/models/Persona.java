package practica_ejercio_poo_parte1.src.meli.practica.models;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


    public Persona(){}

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
        double imc = (this.peso/(this.altura*this.altura)) - (this.peso/1000);
        int resultado = 0;
        
        if(imc < 20){
            resultado = -1;
        }

        if(imc >= 20 && imc <= 25){
            resultado = 0;
        }

        if(imc > 25){
            resultado = 1;
        }

        return resultado;
    }


    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
               "nombre='" + this.nombre + '\'' +
               ", edad=" + this.edad +
               ", dni='" + this.dni + '\'' +
               ", peso=" + this.peso +
               ", altura=" + this.altura +
               '}';
    }

}
