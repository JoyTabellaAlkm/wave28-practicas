
public class Persona{

  private String nombre;
  private String dni;
  private int edad;
  private double peso;
  private double altura;

  Persona(){}

  Persona(String nombre, String dni, int edad){
    this.nombre = nombre;
    this.dni = dni;
    this.edad = edad;
  }

  Persona(String nombre, String dni, int edad, double peso, double altura){
    this.nombre = nombre;
    this.dni = dni;
    this.edad = edad;
    this.peso = peso;
    this.altura = altura;
  }

  int calcularIMC(){
    double valor = this.peso / (this.altura * this.altura);
    return (valor < 20 ? -1 : (valor <= 25 ? 0 : 1));
  }

  String nivelPeso(){
    int nivel = calcularIMC();
    return ( nivel == -1 ? "Bajo" : (nivel == 0 ? "Saludable" : "Sobrepeso") );
  }

  boolean esMayorDeEdad(){
    return this.edad >= 18;
  }
  
  String myToString(){ //toString ya existe, creamos la propia xd
    return "[" + nombre + ", " + dni + ", " + Integer.toString(edad) + ", " + Double.toString(peso) + ", " + Double.toString(altura) + "]";
  }
}