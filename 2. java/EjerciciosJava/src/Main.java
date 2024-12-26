public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Cristhian",25.6,25,"80.0",1.65);
        Persona persona1 = new Persona("Cristhian",25,"172384");
        Persona personaFinal = new Persona("denisse", 18, 25, "60.0", 1.55);

        int imc = personaFinal.cacularIMC();
        switch ((int) imc){
            case -1 -> System.out.println("Bajo de peso.");
            case 0 -> System.out.println("Peso saludable.");
            case 1 -> System.out.println("Sobrepeso.");
        }

        if(personaFinal.esMayorDeEdad()){
            System.out.println("Es mayor de edad.");
        }else {
            System.out.println("Es menor de edad.");
        }

        System.out.println("Información de la persona:");
        System.out.println(personaFinal.toString());

    }
}