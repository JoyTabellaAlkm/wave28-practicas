package supermercado;

public class Item {

    private String codigo;
    private String nombre;
    private double cantidad;
    private double costoUnitario;

    public Item(String codigo, String nombre, double cantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }
}
