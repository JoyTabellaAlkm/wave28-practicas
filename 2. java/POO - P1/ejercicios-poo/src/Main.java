public class Main {
    public static void main(String[] args) {
        Persona primeraPersona = new Persona();
        Persona segundaPersona = new Persona("Pepe",33,"74621541");
        Persona terceraPersona = new Persona("Pepito",20,"12641752",60.40,1.65);

        // No se puede creara debido que no existe un constructor que reciba solo 2 parámetros
        //Persona cuartaPersona = new Persona("Jose",22);

        int imcIndice = terceraPersona.calcularIMC();
        System.out.println("Información de " + terceraPersona.nombre + ": ");
        String mensajeIMC = "Según su IMC, se puede decir sobre su peso: ";
        switch (imcIndice){
            case -1:
                mensajeIMC += "Bajo peso";
                break;
            case 0:
                mensajeIMC += "Peso saludable";
                break;
            case 1:
                mensajeIMC += "Sobrepeso";
        }
        String esMayorDeEdad = "Es " + (terceraPersona.esMayorDeEdad() ? "mayor" : "menor") + " de edad";
        System.out.println(terceraPersona);
        System.out.println(mensajeIMC);
        System.out.println(esMayorDeEdad);
    }
}
