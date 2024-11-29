package ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    @Override
    public double calcular(int cantidadProductos) {
        double precio =  this.getPrecio() * cantidadProductos;
        switch (this.diasPorCaducar){
            case 1:
                precio = precio * 0.25;
                break;
            case 2:
                precio = precio * 0.33;
                break;
            case 3:
                precio = precio * 0.5;
                break;
        }
        return precio;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
