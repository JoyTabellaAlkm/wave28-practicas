public class Main {
    public static void main(String[] args) {
        Persona personaSinDatos = new Persona();
        Persona personaSinMedidas = new Persona("John Doe", "28", "34563452");
        Persona personaCompleta = new Persona("John Doe", "28", "34563452", 65.5, 60);

        System.out.println("IMC: " + personaCompleta.cacularIMC());
        System.out.println(personaCompleta + (personaCompleta.esMayorDeEdad() ? " es" : " no es") + " mayor de edad");

    }
}