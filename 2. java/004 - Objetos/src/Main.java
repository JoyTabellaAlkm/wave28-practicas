public class Main {
        public static void main(String[] args) {
            Persona persona1 = new Persona();
            Persona persona2 = new Persona("123", "Andres", 25);
            Persona persona3 = new Persona("123", "Andres", 25, 69.8, 1.75);

            //Persona persona2 = new Persona("Andres",25); //No es posible, pues, no hay un constructor definido para esos parametros
            int imc = persona3.calcularIMC();

            System.out.println("La persona " + persona3.nombre + (imc == -1 ? " está por debajo del peso ideal" : imc == 0 ? " está en el peso ideal" : " está por encima del peso ideal"));
            System.out.println(persona3.nombre +(persona3.esMayorDeEdad()? " es " : " no es ")+"Mayor de edad");
            System.out.println(persona3.toString());
        }
    }
