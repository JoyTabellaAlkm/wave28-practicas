public class Producto {
    protected String name;
    protected double price;

    //Constructor
    public Producto(String name, double precio){
        this.name = name;
        this.price = precio;
    }

    //getters
    public double getPrecio() {
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrecio(double precio) {
        this.price = precio;
    }

    @Override
    public String toString(){
        return """
                Nombre: %s,
                Precio: %s
                """.formatted(this.name, this.price);
    }

    public double calculate(int cantidadDeProductos){
        return cantidadDeProductos*this.price;
    }
}
