package CRUD;

import Clases.Cliente;
import Clases.Factura;
import Clases.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacturaCRUD implements ICRUD <Factura> {

    public FacturaCRUD() {}

    @Override
    public Factura create() {
        return new Factura();
    }

    @Override
    public void delete(List<Factura> lista, int id) {

    }

    @Override
    public Factura buscar(List<Factura> lista, int id) {
        return null;
    }

    @Override
    public void listarTodos(List<Factura> lista) {
        System.out.println(lista);
    }
}
