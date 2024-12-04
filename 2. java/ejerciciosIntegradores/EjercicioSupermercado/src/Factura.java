import java.util.ArrayList;
import java.util.List;

public class Factura {
    Clientes cliente;
    List<Items> items = new ArrayList();
    double totalDeLaFactura = 0;

    public Factura(Clientes cliente, List<Items> items, double totalDeLaFactura) {
        this.cliente = cliente;
        this.items = items;
        this.totalDeLaFactura = this.calcularTotalDeLaFactura();
    }

    public double getTotalDeLaFactura() {
        return totalDeLaFactura;
    }

    public void setTotalDeLaFactura(double totalDeLaFactura) {
        this.totalDeLaFactura = totalDeLaFactura;
    }

    public double calcularTotalDeLaFactura(){
            return items.stream()
                    .mapToDouble(x -> x.getPrecio())
                    .sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalDeLaFactura=" + totalDeLaFactura +
                '}';
    }
}
