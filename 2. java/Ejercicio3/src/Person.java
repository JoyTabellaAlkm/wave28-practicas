import java.util.Optional;

public class Person {
    String nombre, dni;
    Integer edad;
    Double peso, altura;

    public String toString(){
        String response = nombre + ", " + edad + ", " + dni + ", " +
                peso.toString() + ", " + altura.toString() + ", " + calcularIMCInternal().toString()
                + ", Es mayor de edad:" + esMayorDeEdad();
        return response;
    }

    public Person() {
    }

    public Person(String nombre, String edad, String dni) {
        this.nombre = nombre;
        this.edad = Integer.parseInt(edad);
        this.dni = dni;
    }

    public Person(String nombre, Integer edad, String dni, Double peso, Double altura) {
        System.out.println("Existo!" + peso.toString());
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    private Double calcularIMCInternal() {
        return peso / (Math.pow(altura, 2));
    }

    public Optional<Integer> calcularIMC() {
        if(peso != 0 && altura != 0 ) {
            Double imc = calcularIMCInternal();
            if(imc < 20) {
                return Optional.of(-1);
            }
            else if(imc >= 20 && imc <= 25) {
                return Optional.of(0);
            }
            else {
                return Optional.of(1);
            }
        }
        else{
            System.out.println("No tengo los datos necesarios");
            return Optional.empty();
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }
}
