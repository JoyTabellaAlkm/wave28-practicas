public class App {
    public static void main(String[] args) throws Exception {
        Persona persona = new Persona();
        Persona persona1 = new Persona("juan",20,"10154232343");
        Persona persona2 = new Persona("pedro",21,"10154232354", 68, 1.75);
        //Persona persona3 = new Persona("Sara",20);
       
        boolean esMayorDeEdad = persona2.esMayorDeEdad();
        int IMC = persona2.calcularIMC();

        if(esMayorDeEdad){
            System.out.println("\n"+persona2.nombre + " es Mayor de edad");
        }else{
            System.out.println("\n"+persona2.nombre + " no es Mayor de edad");
        }

        if(IMC == -1){
            System.out.println("\n"+persona2.nombre + " tiene bajo peso");
        }else if(IMC == 0){
            System.out.println("\n"+persona2.nombre + " tiene peso saludable");
        }else{
            System.out.println("\n"+persona2.nombre + " tiene sobrepeso");
        }

        System.out.println("\n"+persona2.toString());
    }
}
