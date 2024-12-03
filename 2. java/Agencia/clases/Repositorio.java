package clases;

import java.util.List;

public class Repositorio {
    private String name;
    private List<Localizador> localizador;

    private List<Cliente> clientes;

    public Repositorio(String name, List<Localizador> localizador, List<Cliente> clientes){
        this.name = name;
        this.localizador = localizador;
        this.clientes = clientes;
    }

    public String getName() {
        return name;
    }

    public List<Localizador> getLocalizador() {
        return localizador;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente addCliente(String name, String lastName){
        Cliente cliente = new Cliente(this.clientes.size()+1, name, lastName);
        this.clientes.add(cliente);
        return cliente;
    }

    public Localizador addLocalizador(int clienteId, List<Reserva> reservas){
        Localizador localizador = new Localizador(this.localizador.size()+1, clienteId, reservas);
        this.localizador.add(localizador);
        return localizador;
    }

    public void filterLocalizadoresByClient(int clienteId){
        List<Localizador> filterLocalizadores = this.localizador.stream().filter((l)-> l.getClienteId() == clienteId).toList();
        for (Localizador localizador: filterLocalizadores) {
            System.out.println(localizador);
        }
        System.out.println("---------------------------------------");
    }

    public void calculatePriceByLocalizador(int localizadorId){
        Localizador localizador = this.localizador.stream().filter((l) -> l.getId() == localizadorId).reduce((a, b) -> {
                    throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                })
                .get();
        double price = 0;
        int countHotel = 0;
        int countVuelo = 0;
        double fiveDiscount = 0;
        for (Reserva reserva: localizador.getReservas()) {
            double fullDiscount = (
                    reserva.getHaveBoletos()
                            && reserva.getHaveHotel() &&
                            reserva.getHaveTransporte() &&
                            reserva.gethaveComida()
            ) ? reserva.getPrice() * 0.1 : 0;
            countHotel += (reserva.getHaveHotel()) ? 1 : 0;
            countVuelo += (reserva.getHaveBoletos()) ? 1: 0;
            if (countVuelo == 0 || countHotel == 0){
                fiveDiscount = reserva.getPrice() * 0.05;
            }
            System.out.println("Precio del paquete: " + reserva.getPrice());
            System.out.println("Descuento por full plan: " + fullDiscount);
            System.out.println("Descuento por 2 hoteles o 2 vuelos: "+ fiveDiscount);
            System.out.println("Precio del paquete final: " + (reserva.getPrice() - fullDiscount - fiveDiscount));
            price += reserva.getPrice() - fullDiscount - fiveDiscount;

            if (fiveDiscount > 0){
                countVuelo = 0;
                countHotel = 0;
                fiveDiscount = 0;
            }
            System.out.println("---------------------------------------");
        }

        System.out.println("El precio del localizador es: " + price);
        System.out.println("---------------------------------------");
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void totalReservas(){
        int count = 0;
        for (Localizador localizador: this.localizador) {
            count += localizador.getReservas().size();
        }
        System.out.println("Se realizaron un total de " + count + " reservas");
    }

    public void setLocalizador(List<Localizador> localizador) {
        this.localizador = localizador;
    }
}
