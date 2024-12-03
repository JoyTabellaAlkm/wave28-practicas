package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioCliente {
        private List<Localizador> listaLocalizadores;

        public RepositorioCliente() {
                this.listaLocalizadores= new ArrayList<>();
        }

        public void agregarLocalizador(Localizador localizador){
                listaLocalizadores.add(localizador);
        }

        private List<Localizador> buscarLocalizadoresPorCliente(Cliente cliente){
                return listaLocalizadores.stream().filter(l->l.getCliente().equals(cliente)).collect(Collectors.toList());
        }

        public void aplicarDescuentosPorCliente(Cliente cliente){
               List<Localizador> listaLocalizadoresPorCliente =  buscarLocalizadoresPorCliente(cliente);
//                System.out.println(listaLocalizadoresPorCliente);
                List<Reserva> listReservaPorCliente = listaLocalizadoresPorCliente.stream().map(r->r.getListaReservas()).toList();
                int cantidadHotel =0;
                for (Reserva reserva: listReservaPorCliente) {
                        if(reserva instanceof Hotel){
                               cantidadHotel = cantidadHotel++;
                        }
                        if(reserva instanceof Hotel){
                                cantidadHotel = cantidadHotel++;
                        }

                }
                List<List<Reserva>> lista =  listaLocalizadoresPorCliente.stream().map(l->l.getListaReservas().stream().filter(reserva -> reserva instanceof Hotel).toList()).toList();

        };







        }
