package practica_agencia_turismo.src.meli.practica.services;

import java.util.ArrayList;
import java.util.List;

import practica_agencia_turismo.src.meli.practica.models.Cliente;
import practica_agencia_turismo.src.meli.practica.models.Localizador;

public class ServicioEstadisticas {

    List<Cliente> clientes = new ArrayList<>();

    public ServicioEstadisticas(List<Cliente> clientes){
        this.clientes = clientes;
    }

    public int cantidadLocalizadoresVendidos(){

        int totalLocalizadores = 0;

        for(Cliente cliente: clientes){
            totalLocalizadores += cliente.cantidadLocalizadores();
        }

        return totalLocalizadores;
    }

    public int cantidadReservas(){

        int totalReservas = 0;

        for(Cliente cliente: clientes){
            for(Localizador localizador: cliente.obtenerLocalizadores()){
                totalReservas += localizador.cantidadReservas();
            }
        }
        
        return totalReservas;
    }

}
