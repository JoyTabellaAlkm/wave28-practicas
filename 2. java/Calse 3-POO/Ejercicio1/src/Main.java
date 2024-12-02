public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Gabriel", 26, "123");
        Persona persona3 = new Persona("Luciana", 15, "9876", 50, 1.90);

        //Persona persona4 = new Persona("Gabriel", 26);
        //No permite porque no exite un constructor con solo esos dos parametros

        int resultado = persona3.calcularIMC();

        if (resultado == -1) {
            System.out.println("Por debajo de 20");
            System.out.println("Bajo peso");
        } else if (resultado == 0) {
            System.out.println("Entre 20 y 25 inclusive");
            System.out.println("Peso saludable");
        } else if (resultado == 1) {
            System.out.println("Mayor de 25");
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Clasificación: Obesidad");
        }

        System.out.println(persona3.esMayorDeEdad() ? "Si, es mayor de edad" : "No, es menor de edad");
    }
}
