import Implementations.Clientes.Basic;
import Implementations.Clientes.Cliente;
import Implementations.Clientes.Cobrador;
import Implementations.Clientes.Ejecutivo;
import Implementations.Transacciones.*;
import Interfaces.ITransaccion;

public class Main {
    public static void main(String[] args) {
        ITransaccion consultaSaldo = new ConsultaSaldo();
        ITransaccion deposito = new Deposito();
        ITransaccion pagoServicio = new PagoServicio();
        ITransaccion retiroEfectivo = new RetiroEfectivo();
        ITransaccion transferencia = new Transferencia();

        Cliente ejecutivo = new Ejecutivo("Pedro");
        Cliente basic = new Basic("Juan");
        Cliente cobrador = new Cobrador("Jazmin");

        System.out.println(ejecutivo.getNombre());
        ejecutivo.realizarTransaccion(retiroEfectivo);
        ejecutivo.realizarTransaccion(deposito);
        System.out.println();

        System.out.println(basic.getNombre());
        basic.realizarTransaccion(deposito);
        basic.realizarTransaccion(consultaSaldo);
        System.out.println();

        System.out.println(cobrador.getNombre());
        cobrador.realizarTransaccion(deposito);
        cobrador.realizarTransaccion(consultaSaldo);
        System.out.println();
    }
}