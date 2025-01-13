package repository;

import model.Prenda;

import java.util.List;

public interface IGuardaRopa {
    Integer guardarPrendas(List<Prenda> listaDePrenda);
    void mostrarPrendas();
    List<Prenda> devolverPrendas(Integer numero);
}
