public class Perecedero extends Producto{
    private Integer diasPorCaducar;

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public Double calcular(Integer cantidad) {
        switch (diasPorCaducar){
            case 1:{
                return this.getPrecio()*cantidad * 0.25;
            }
            case 2:{
                return this.getPrecio()*cantidad*0.33;
            }
            case 3:{
                return this.getPrecio()*cantidad*0.5;
            }
            default:{
                return this.getPrecio()*cantidad;
            }
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "nombre='" + this.getNombre() + '\'' +
                ", precio=" + this.getPrecio() +'\'' +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
