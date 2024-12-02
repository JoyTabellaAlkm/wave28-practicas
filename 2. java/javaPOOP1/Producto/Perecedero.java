package Producto;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCalcular() {
        return diasPorCaducar;
    }

    public void setDiasPorCalcular(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
    
    public double diasPorCaducar(int dias){
        double totalDescontar;
        switch (dias){
            case 1:
                totalDescontar = precio * 0.75;
                break;
            case 2:
                totalDescontar = precio * 0.50;
                break;
            case 3:
                totalDescontar = precio * 0.25;
                break;
            default:
                totalDescontar = 0;
                break;
        }
        return totalDescontar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        return (super.calcular(cantidadDeProductos)) - diasPorCaducar(diasPorCaducar);
    }

}
