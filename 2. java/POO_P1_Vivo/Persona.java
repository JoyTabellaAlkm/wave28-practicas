public class Persona {
    String nombre;
    int edad;
    String DNI;
    double peso;
    double altura;

    public Persona()
    {
    }

    public Persona(String nombre, int edad, String DNI)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona (String nombre, int edad, String DNI, double peso, double altura)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC()
    {
        double valor = this.peso/(this.altura * this.altura);
        if (valor < 20)
            return -1;
        if (valor < 25)
            return 0;
        return 1;
    }

    public boolean esMayorDeEdad()
    {
        return edad >= 18;
    }

    public String toString()
    {
        return String.format("Nombre: %s DNI: %s Peso: %s Altura: %s",
                             this.nombre, this.DNI, this.peso, this.altura);
    }
}
