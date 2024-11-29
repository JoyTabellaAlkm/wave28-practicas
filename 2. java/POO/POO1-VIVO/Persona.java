public class Persona {
    /*
     * Creá una clase Persona, la cual tendrá los siguientes atributos:
     * nombre, edad, dni (en este caso vamos a representarlo como una cadena de
     * caracteres),
     * peso y altura ¿Qué tipo de dato le asignarías a las variables de instancia?
     * ¿Cómo sería la estructura básica de tu clase?
     */
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    /*
     * Vamos a crear diferentes constructores en la clase Persona,
     * uno sin parámetros, el segundo debe recibir como parámetro nombre, edad y
     * dni;
     * por último creamos un tercero que reciba todos los atributos de la clase como
     * parámetro.
     */

    public Persona() {

    }

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

    /*
     * En la clase Persona implementaremos los siguientes métodos: cacularIMC(),
     * la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y
     * altura en mts),
     * si este cálculo devuelve un valor menor que 20, la función debe retornar -1,
     * si devuelve un
     * número entre 20 y 25 inclusive para los dos valores, el metodo debe retornar
     * un 0,
     * por último, si devuelve un número mayor que 25 debe retornar un 1. Una vez
     * creado el
     * metodo anterior, agreguemos el metodo esMayorDeEdad() el cual debe retornar
     * una valor
     * booleano, teniendo en cuenta que la mayoría de edad será considerada en este
     * caso, a
     * partir de los 18 años.
     * Finalmente agregar un metodo toString() que va a devolver toda
     * la información de la persona.
     * ¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para
     * calcular la potencia.
     */

    public int calcularIMC() {
        double imc = peso / (altura * altura);
        if (imc < 20) {
            return -1;
        } else if (imc <= 25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad() {
        if (edad < 18) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "El nombre es: " + nombre + ". Su edad es: " + edad + ". Su DNI es: " + dni
                + ".Su peso es: " + peso + "Kg.Su altura es: " + altura + "mts.";
    }

}
