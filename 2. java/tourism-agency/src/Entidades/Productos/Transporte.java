package Entidades.Productos;

public class Transporte extends Producto{
    public Transporte(){
        this.setCosto(100);
        this.setNombre("Transporte");
    }

    public Transporte(double costo, String nombre){
        this.setCosto(costo);
        this.setNombre(nombre);
    }

    public String toString() {
        return "[Transporte] " + super.toString();
    }

}
