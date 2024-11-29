public class Perecedero extends Poducto{

    private int diasPorCaducar;

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

    public String toString() {
        return super.toString() + " DiasPorCaducar: " + diasPorCaducar;
    }

    @Override
    public int calcular(int cantidadDeProductos) {
            if(diasPorCaducar <= 0){
                throw new IllegalArgumentException("El producto esta vencido");
            } else {
                switch (diasPorCaducar) {
                    case 1:
                        return (((int) super.getPrecio()) * cantidadDeProductos)/4;
                    case 2:
                        return (((int) super.getPrecio()) * cantidadDeProductos)/3;
                    case 3:
                        return (((int) super.getPrecio()) * cantidadDeProductos)/2;
                    default:
                        return (((int) super.getPrecio()) * cantidadDeProductos);
            }
        }
    }
}