//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona personaSinAtributos = new Persona();
        Persona personaConNombreDniEdad = new Persona("Juan", "1234", 10);
        Persona personaConTodosLosAtributos = new Persona("Jose", "1222", 20, 1.80, 80.0);

        int imc = personaConTodosLosAtributos.calcularIMC();
        boolean esMayor = personaConTodosLosAtributos.esMayorDeEdad();

        switch (imc) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludalbe");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("El imc esta mal!");
                break;
        }

        if (esMayor) {
            System.out.println("Es mayor de edad!");
        } else {
            System.out.println("Es menor de edad!");
        }
    }
}