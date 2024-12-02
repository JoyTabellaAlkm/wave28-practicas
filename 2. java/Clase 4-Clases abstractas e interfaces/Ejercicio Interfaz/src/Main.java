public class Main {
    public static void main(String[] args) {
        //Transactions
        ITransaccion deposito = new Deposito();
        ITransaccion transferencia = new Transferencia();
        ITransaccion retiroDeEfectivo = new RetiroDeEfectivo();
        ITransaccion consultaDeSaldo = new ConsultaDeSaldo();
        ITransaccion pagoServicios = new PagoServicios();

        //Clients
        ICliente clienteEjecutivo = new Ejecutivos();
        ICliente clienteBasic = new Basic();
        ICliente clienteCobrador = new Cobrador();

        //Operations
        clienteEjecutivo.realizarTransaccion(deposito); //Ok
        clienteEjecutivo.realizarTransaccion(pagoServicios);//Not allowed

        clienteBasic.realizarTransaccion(consultaDeSaldo);//Ok
        clienteBasic.realizarTransaccion(transferencia);//Not allowed

        clienteCobrador.realizarTransaccion(retiroDeEfectivo);//Ok
        clienteCobrador.realizarTransaccion(transferencia);
    }
}