public class Automovil {

    private String marca;
    private String color;
    private double kilometros;

    public Automovil(){
        this.marca = "";
        this.color = "";
        this.kilometros = 0.0;
    }

    public Automovil(String marca, String color, double kilometros){
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor(){
        String marcaYColor = "la marca del auto es: " + this.marca + ". El color del auto es: " +  this.color;
        return marcaYColor;
    }
}
