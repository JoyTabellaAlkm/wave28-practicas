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

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    /*
     * cacularIMC(), la fórmula para calcularlo es: peso/(altura^2) - 
     * (peso expresado en kg y altura en mts), si este cálculo devuelve un valor menor que 20, 
     * la función debe retornar -1, si devuelve un número entre 20 y 25 inclusive para los dos valores, 
     * el método debe retornar un 0, por último, si devuelve un número mayor que 25 debe retornar un 1. 
     */

     public int calcularIMC(){
        double IMC = (this.peso/(this.altura*this.altura));
        if(IMC < 20){
            return -1;
        }else if(IMC<=25){
            return 0;
        }
        return 1;
     }

     public boolean esMayorDeEdad(){
        if(this.edad>=18){
            return true;
        }
        return false;
     }

     public String toString(){
        return "Nombre: " + this.nombre + 
        "; edad: " + this.edad +
        " años; dni: " + this.dni +
        "; peso: " + this.peso + 
        "kg; altura: " + this.altura+"mt";
     }


}