public class Perecedero extends Producto {

    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero [ nombre=" + getNombre() + ", precio=" + getPrecio() +", diasPorCaducar=" + this.diasPorCaducar+"]";
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioFinal = cantidadDeProductos*getPrecio();

        switch (this.diasPorCaducar) {
            case 1:
                return precioFinal/4;
            case 2:
            return precioFinal/3;
            
            case 3:
            return precioFinal/2;
        }

        return precioFinal;
    }
}