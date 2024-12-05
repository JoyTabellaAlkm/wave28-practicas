import java.util.*;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> itemsDeCompra ;
    private int montoTotal ;


    public Factura(Cliente cliente, ArrayList<Item> itemsDeCompra){
        this.cliente = cliente;
        this.itemsDeCompra = ArrayList.of(itemsDeCompra);;
    }

}
