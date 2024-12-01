package EjercicioClase1;


public class Main {

    public static void main(String[] args) {
        // Instancia de personas
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "123456789");
        Persona persona3 = new Persona("Santiago", 30, "7338287387", 80.0, 1.80);

        // Utilización atributos y metodos de persona
        System.out.println("La persona: " +persona3);
        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");
        System.out.println("Resultado");
        int resultado = persona3.calcularIMC();
        switch (resultado) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                break;
        }
    }
}
