package practicaClasesAbstractasInterfaces.PracticaReservas.entidades;

import java.util.List;

public class Localizadores {
        private Clientes cliente;
        private Double total;
        private List<String> listaReserva;

    public List<String> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<String> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Localizadores(Clientes cliente, List<String> listaReserva) {
        this.cliente = cliente;
        this.listaReserva = listaReserva;
    }

    public Localizadores() {
    }

    @Override
    public String toString() {
        return "Localizadores{" +
                "listaReserva=" + listaReserva +
                '}';
    }
}
