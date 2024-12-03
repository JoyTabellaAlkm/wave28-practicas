package Entidades.Productos;

public class Comida extends Producto{
    public Comida(){
        this.setCosto(250);
        this.setNombre("Comida");
    }

    public Comida(double costo, String nombre){
        this.setCosto(costo);
        this.setNombre(nombre);
    }

    public String toString() {
        return "[Comida] " + super.toString();
    }

}
