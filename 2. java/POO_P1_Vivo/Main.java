public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Pepe",33,"74621541");
        Persona persona3 = new Persona("Pepito",20,"12641752",23.40,1.65);
//      Persona persona4 = new Persona("Jose",22); esto falla, el ejercicio pide instanciar con parametros que no acepta ningun constructor

        String mensajeMayorDeEdad = persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad";
        String mensajeIMC = "Tipo de peso: ";
        switch (persona3.calcularIMC()){
            case -1:
                mensajeIMC += "Bajo peso";
                break;
            case 0:
                mensajeIMC += "Peso saludable";
                break;
            default:
                mensajeIMC += "Sobrepeso";
        }
        
        System.out.println(persona3.toString());
        System.out.println(mensajeMayorDeEdad);
        System.out.println(mensajeIMC);
    }
}