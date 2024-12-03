package Entidades.Productos;

public class Boleto extends Producto{
    public Boleto(){
        this.setCosto(500);
        this.setNombre("Boleto");
    }

    public Boleto(double costo, String nombre){
        this.setCosto(costo);
        this.setNombre(nombre);
    }

    @Override
    public String toString() {
        return "[Boleto] " + super.toString();
    }
}
