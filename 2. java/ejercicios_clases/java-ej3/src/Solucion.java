public class Solucion {


    public static class Persona {
        String nombre;
        int edad;
        String dni;
        Double altura;
        Double peso;

        public Persona() {
        }

        public Persona(String nombre, int edad, String dni, Double altura, Double peso) {
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
            this.altura = altura;
            this.peso = peso;
        }

        public Persona(String nombre, int edad, String dni) {
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
        }

        public int calcularIMC() {
            Double indice = peso/(altura*altura);
            if(indice < 20) {
                return -1;
            }else if(indice >= 20 && indice <= 25) {
                return 0;
            }else return 1;
        }

        public Boolean esMayorDeEdad() {
            return edad >= 18;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", dni='" + dni + '\'' +
                    ", altura=" + altura +
                    ", peso=" + peso +
                    '}';
        }
    }

    static class Main {
        public static void main(String[] args) {
            Persona persona1 = new Persona("Dario", 40, "31218999", 1.76, 78.5  );
            Persona persona2 = new Persona("Tomas", 33, "2134566" );
            Persona persona3 = new Persona();


            switch (persona1.calcularIMC()){
                case 1: System.out.println("Sobre peso");
                    break;
                case -1: System.out.println("Bajo peso");
                    break;
                case 0: System.out.println("Saludable");
            }
            if(persona1.esMayorDeEdad()) {
                System.out.println("Es mayor de edad");
            }else  System.out.println("Es menor de edad");

        }

    }
}