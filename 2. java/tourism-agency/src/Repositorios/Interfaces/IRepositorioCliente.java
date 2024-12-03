package Repositorios.Interfaces;

import Entidades.Reserva;

import java.util.List;

public interface IRepositorioCliente {
    public List<Reserva> buscarReservas();
    public double aplicarDescuentos();
}
