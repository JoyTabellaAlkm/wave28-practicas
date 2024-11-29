public class Main {
    public static void main(String[] args)
    {
        Persona person1 = new Persona();
        Persona person2 = new Persona("Simon", 41, "14132134");
        Persona person3 = new Persona("Luis", 45, "42433412", 110.4f, 180.4f);

        // Desde la clase Main vamos a calcular el IMC de la última persona que creamos
        // (la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro).
        // También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos,
        // dependiendo de los resultados retornados por los métodos, debes imprimir un mensaje acorde para el usuario.

        System.out.println(person3.toString());

        switch (person3.calcularIMC()) {
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
                System.out.println("IMC: N/A");
                break;

        }


        if(person3.esMayorDeEdad()){
            System.out.println(person3.getName() + " es mayor de edad");
        } else {
            System.out.println(person3.getName() + " es menor de edad");
        }



    }
}
