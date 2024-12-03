package repositories;

import classes.Cliente;
import classes.Factura;
import classes.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepositorio implements ICrud<Factura>{

    List<Factura> listaFacturas = new ArrayList<>();
    @Override
    public void guardar(Factura props) {
        listaFacturas.add(props);
    }

    @Override
    public Factura buscar(int codigo) {
        Factura factura =
                listaFacturas.stream().filter(fac -> fac.getCodigo() == codigo).toList().getFirst();
        if (factura == null){
            throw new RuntimeException("Cliente no encontrado");
        }
        return factura;
    }

    @Override
    public List<Factura> buscartodos() {
        return listaFacturas;
    }

    @Override
    public void eliminar(int codigo) {
        boolean encontrado = false;
        for (Factura factura : listaFacturas) {
            if (factura.getCodigo() == codigo) {
                listaFacturas.remove(factura);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            throw new RuntimeException("Factura no encontrado");
        }
    }
}
