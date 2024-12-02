class Main{
    public static void main(String[] args) {
        Automovil automovil = new Automovil("Ford", "Red", 5);
        System.out.println(automovil.mostrarMarcaYColor());
    }
}

public class Automovil {

    public String marca;
    public String color;
    public double kilometros;

    public  Automovil() {
    }

    public  Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;
    }
}
