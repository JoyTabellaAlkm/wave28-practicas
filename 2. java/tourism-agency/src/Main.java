import Entidades.*;
import Entidades.Productos.*;
import Repositorios.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repoCliente = new RepositorioCliente();
        RepositorioLocalizador repoLocalizador = new RepositorioLocalizador();

        Cliente cliente1 = new Cliente("Esteban", "Quito", 41423423);
        repoCliente.agregarCliente(cliente1);

        Reserva reserva1 = new Reserva();
        reserva1.agregarProducto(new Comida());
        reserva1.agregarProducto(new Boleto());
        reserva1.agregarProducto(new Transporte());
        reserva1.agregarProducto(new Hotel());

        Localizador localizador1 = new Localizador(
                1,
                cliente1,
                reserva1
        );



        repoLocalizador.agregarLocalizadores(localizador1);



    }
}
