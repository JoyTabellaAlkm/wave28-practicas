package ejercicios.ejercicio1POO;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura; //metros

    public Persona() {}

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC(){
       double res =  this.peso / Math.pow(this.altura, 2);
       if (res<20){
           return -1;}
       if (res>=20 && res<25){
           return 0;
       }
       if (res>25){
           return 1;
       }
        return 0;
    }

    public boolean esMayorDeEdad (){
        return (this.edad>=18);
    }

    @Override
    public String toString() {
        return STR."Nombre=\{nombre}, Edad=\{edad}, DNI=\{dni}, Peso=\{peso}, Altura=\{altura}";
    }

    public String getNombre() {
        return nombre;
    }
}
