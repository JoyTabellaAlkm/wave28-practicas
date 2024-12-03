package model;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cli;
    private List<Item> listaItems;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cli, List<Item> listaItems) {
        this.codigo = codigo;
        this.cli = cli;
        this.listaItems = listaItems;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }
}
