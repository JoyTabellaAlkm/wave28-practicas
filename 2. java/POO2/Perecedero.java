public class Perecedero extends Producto {
    protected int diasPorCaducar;

    public Perecedero(String name, double price, int diasPorCaducar){
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;
    }

    //setter
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //getter
    public int getDiasPorCaducar() {
        return this.diasPorCaducar;
    }

    @Override
    public double calculate(int cantidadDeProductos){
        double price = cantidadDeProductos*this.price;
        double finalPrice = (this.diasPorCaducar ==1 ) ? price*0.25 : (this.diasPorCaducar == 2) ? price*0.33 : (this.diasPorCaducar == 3) ? price * 0.5 : price;
        return finalPrice;
    }

    @Override
    public String toString(){
        return """
                Nombre: %s,
                Precio: %s,
                Dias por caducar: %s
                """.formatted(this.name, this.price, this.diasPorCaducar);
    }
}
