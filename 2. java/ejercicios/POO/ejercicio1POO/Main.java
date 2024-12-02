package ejercicios.POO.ejercicio1POO;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Carolina", 27, "40851933");
        Persona persona3 = new Persona("Homero", 27, "40851933", 55.6,172);

        //Persona personaRompe = new Persona("caro", 77);

        int imc = persona3.calcularIMC();
        System.out.print("El nivel de peso es: ");
        switch (imc) {
            case -1:
                System.out.println("Bajo de peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }
        boolean res = persona3.esMayorDeEdad();
        if (res){
           System.out.println("La persona llamada " + persona3.getNombre() + " es mayor de edad");
        }
        else {
            System.out.println("La persona llamada " + persona3.getNombre() + " es menor de edad");
        }


        System.out.println(persona3.toString());

    }
}
