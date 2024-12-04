package ejercicio1Banco.clientes;

import ejercicio1Banco.transacciones.ITransaccion;

public interface ICliente {
    public void realizarTransaccion(ITransaccion transaccion);
}
