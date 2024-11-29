public class Main {
    public static void main(String[] args) {
        Persona personaConstructorVacio = new Persona();
        Persona personaConstructorBasico = new Persona("Pedro", 21, "1234");
        Persona personaConstructorFull = new Persona("Pedro", 21, "1234", 70.2, 1.80);

        /*No funciona ya que no existe el constructor*/
        /*Persona personaError1 = new Persona("Pedro", 21);*/

        boolean esMayorDeEdad = personaConstructorFull.esMayorDeEdad();

        if (esMayorDeEdad) {
            System.out.println(personaConstructorFull.nombre + " Es mayor de edad");
        }

        int IMC = personaConstructorFull.calcularIMC();

        if (IMC == -1) {
            System.out.println(personaConstructorFull.nombre + " tiene nivel de peso bajo");
        }
        else if (IMC == 0) {
            System.out.println(personaConstructorFull.nombre + " tiene nivel de peso saludable");
        }
        else {
            System.out.println(personaConstructorFull.nombre + " tiene nivel de peso con sobrepeso");
        }
    }
}