import classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(123123123, "A", "A"));
        clientes.add(new Cliente(234234234, "B", "B"));
        clientes.add(new Cliente(345345345, "C", "C"));

        for (Cliente c: clientes){
            if(Objects.equals(c.getApellido(), "B")){
                c.editarDatos(null, "BB", null);
            }
            c.imprimir();
        }


    }
}
