package Entidades.Productos;

public class Hotel extends Producto{
    public Hotel(){
        this.setCosto(10000);
        this.setNombre("Hotel");
    }

    public Hotel(double costo, String nombre){
        this.setCosto(costo);
        this.setNombre(nombre);
    }

    public String toString() {
        return "[Hotel] " + super.toString();
    }

}
