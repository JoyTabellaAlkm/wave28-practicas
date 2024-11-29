public class Main {
    public static void main(String[] args) {
        Persona martin = new Persona();
        Persona zully = new Persona("Zully", 35, 123123123);
        Persona eliseo = new Persona("Eliseo", 25, 123123123, 65.2, 1.70);

        System.out.println("Datos de " + eliseo.getNombre());
        System.out.println(eliseo.toString());

        switch (eliseo.cacularIMC()) {
            case -1:
                System.out.println("IMC: Bajo peso");
                break;
            case 0:
                System.out.println("IMC: Peso saludable");
                break;
            case 1:
                System.out.println("IMC: Sobrepeso");
                break;
            default:
                System.out.println("IMC: IMPOSIBLE");
                break;

        }

        if (eliseo.esMayorDeEdad()) {
            System.out.println(eliseo.getNombre() + " es mayor de edad");
        } else {
            System.out.println(eliseo.getNombre() + " es menor de edad");
        }

    }
}