package Supermercado;

import java.util.*;

public class Supermercado {

    private Set<Cliente> setCliente = new HashSet() ;

    private List<Factura> listaFactura = new ArrayList<>();
    private Map<Cliente,List<Factura>> clienteFactura= new HashMap<>();

    public Supermercado(){}

    public  void getClientes(){
        for(Cliente cliente: this.setCliente ){
            System.out.println(cliente);

        }    }

    public void agregarFacturaACliente(Cliente cliente, Factura factura){
        if (this.clienteFactura.containsKey(cliente)) {
            this.clienteFactura.get(cliente).add(factura);
        } else {
            List<Factura> nuevasFacturas = new ArrayList<>();
            nuevasFacturas.add(factura);
            this.clienteFactura.put(cliente, nuevasFacturas);
        }
    }
    public void agregarCliente(Cliente cliente){
        this.setCliente.add(cliente);
    }

    public void mostrarListaClienteFactura(){
        for(Map.Entry<Cliente,List<Factura>> entry: clienteFactura.entrySet()){
            Cliente cliente = entry.getKey();
            List<Factura> facturas =  entry.getValue();
            System.out.println( cliente);
            System.out.println();
            for(Factura factura: facturas) {
                System.out.println(factura);
            }
        }
    }

    public void eliminarCliente( Cliente cliente){
        boolean eliminarCliente = setCliente.remove(cliente);
        if(eliminarCliente){
            System.out.println("el cliente se elimino correctamente");
        }
        else{
            System.out.println("El cliente no se elimino");
        }
    }

    public void mostrarCliente(String dni){
        Cliente clienteEncontrado = setCliente.stream()
                .filter(c -> c.getDni().equals(dni))
                .findAny()
                .orElse(null);

        if (clienteEncontrado != null) {
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("El cliente no se encuentra inscripto");
        }
    }


}
