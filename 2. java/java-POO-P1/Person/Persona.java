class Persona {
    private String nombre;
    private int age;
    private String dni;
    private double altura;
    private double peso;

    public static final int BAJO_PESO   = -1;
    public static final int PESO_NORMAL = 0;
    public static final int SOBRE_PESO  = 1;

    public Persona(String nombre, int age, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.age = age;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona(){

    }

    public Persona(String nombre, int age, String dni){
        this.nombre = nombre;
        this.age = age;
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
        if(this.age >= 18){
            return true;
        }
        return false;
    }


    public void obtenerInformacion(){
        System.out.printf("\n**************************************************\n" +
                "NOMBRE: %s\n" +
                "DNI: %s\n" +
                "EDAD: %s %s\n"  +
                "PESO: %s\n" +
                "ALTURA: %s\n" +
                "RESULTADO DE IMC: %s\n" +
                "INTERPRETACION DE IMC: %s\n" +
                "**************************************************\n", this.nombre, this.dni, this.age, (this.esMayorDeEdad()) ? "(Es mayor de edad)" : "(Es menor de Edad)", this.peso, this.altura, this.calcularIMC() ,this.resultIMC());
    }
}