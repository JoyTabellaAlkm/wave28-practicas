public class Item {
    protected String codigo, nombre;
    private int cantidadComprada, costoUnitario;

    public Item(String codigo, String nombre, int cantidadComprada, int costoUnitario){
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
        this.nombre = nombre;
        this.codigo = codigo;
    }



}
