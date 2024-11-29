package ejercitacionMananaJavaDia2;

public class Main{
    public static void main(String[] args) {
        /*
        Creá una clase nueva llamada Main,
        donde declares un metodo main como te enseñamos anteriormente.
        Esto nos permitirá ejecutar nuestra aplicación.
         */
        /*
        En la clase Main que acabamos de crear, dentro del metodo main()
        te pedimos que crees un objeto de tipo Persona por cada constructor
        que hayamos definido en la clase, recuerda poner un nombre significativo a
        las variables donde vas a asignar cada objeto. ¿Cómo lo harías? A continuación
        vamos a crear otro objeto de tipo persona y vamos a construirlo pasando solamente
         un valor para el nombre y otro para la edad en el constructor. ¿Es esto posible?
         ¿Qué sucede si tratamos de hacer esto?
         */

        Persona persona1=new Persona();
        Persona persona2=new Persona("Juan", 22, "95003773");
        Persona persona3=new Persona("Pedro", 30, "45678345", 82.4, 1.78);
        //Persona persona4=new Persona("Lucas", 22); --> no se puede porque no existe un constructor para este formato.

        /*
        Desde la clase Main vamos a calcular el IMC de la última persona que creamos
        (la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro).
        También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos,
        dependiendo de los resultados retornados por los métodos, debes imprimir un mensaje acorde
        para el usuario.
        Finalmente queremos mostrar todos los datos de esa persona imprimiendo dicha
        información por consola. El formato en que vas a mostrar los datos y los mensajes quedan a tu criterio,
        pero debe ser legible y descriptivo para quien ve la salida del programa.
         */

        System.out.println(persona3.toString());
        if (persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad.");
        }
        else{
            System.out.println("Es menor de edad.");
        }
        switch (persona3.calcularIMC()){
            case -1:{
                System.out.println("El IMC es " +persona3.calcularIMC() + " y esta bajo de peso.");
                break;
            }
            case 0:{
                System.out.println("El IMC es " +persona3.calcularIMC() + " y esta en un peso saludable.");
                break;
            }
            default:{
                System.out.println("El IMC es " +persona3.calcularIMC() + " y esta en sobrepeso.");
            }


        }




    }
}
