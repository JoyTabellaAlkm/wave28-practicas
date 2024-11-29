package PooEjercicioPersona;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
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

    public int calcularMasaCorporal(){
        double masaCorporal = this.peso/(this.altura*this.altura);

        if(masaCorporal<20){
            return -1;
        } else if(masaCorporal<=25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad (){
        return this.edad >= 18;
    }

    public String toString() {
        return "Persona{" + "\n" +
                "nombre: '" + nombre + '\'' + ",\n" +
                "edad: " + edad + ",\n" +
                "dni: '" + dni + '\'' + ",\n" +
                "peso: " + peso + ",\n" +
                "altura: " + altura + ",\n" +
                '}';
    }
}
