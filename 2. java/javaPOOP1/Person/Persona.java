package Person;

class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private double peso;

    public static final int BAJO_PESO   = -1;
    public static final int PESO_NORMAL = 0;
    public static final int SOBRE_PESO = 1;

    public Persona(String nombre, int edad, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC() {
        double imc = this.peso / Math.pow(this.altura, 2);
        if (imc < 20) {
            return BAJO_PESO;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_NORMAL;
        } else {
            return SOBRE_PESO;
        }
    }

    public String resultIMC(){
        int imc = this.calcularIMC();
        if(imc <= 20 ){
            return "Bajo peso";
        } else if (imc >= 20 && imc <= 25) {
            return "Peso saludable";
        }else {
            return "Sobrepeso";
        }
    }

    public boolean esMayorDeEdad(){
        if(this.edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  "NOMBRE=" + nombre + '\n' +
                "EDAD=" + edad + '\n' +
                "DNI=" + dni + '\n' +
                "ALTURA=" + altura + '\n' +
                "PESO=" + peso + '\n' +
                "RESULTADO DE IMC:" + this.calcularIMC() + '\n' +
                "INTERPRETACION DE IMC: " +this.resultIMC();
    }

}