import java.util.ArrayList;
import java.util.stream.Collectors;

public class Agencia {
    private ArrayList<Cliente> clientes;
    private ArrayList<Localizador> localizadores;

    public Agencia() {
        this.clientes = new ArrayList<Cliente>();
        this.localizadores = new ArrayList<Localizador>();
    }

    public void agregarCliente(Cliente c){
        this.clientes.add(c);
    }

    public void agregarLocalizador(Localizador l){
        if(){

        }
        this.localizadores.add(l);
    }



    public Object traerLocalizadoresPorCliente(int clienteID){
        return this.localizadores.stream()
                .filter(l -> l.getCliente().equals(clienteID))
                .collect(Collectors.toList());
    }
}
