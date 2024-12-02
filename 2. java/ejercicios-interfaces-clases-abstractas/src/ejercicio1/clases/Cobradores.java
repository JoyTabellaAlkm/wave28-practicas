package ejercicio1.clases;

public class Cobradores {
    private RetiroDeEfectivo retiroDeEfectivo;
    private ConsultaDeSaldo consultaDeSaldo;

    public Cobradores() {
        this.retiroDeEfectivo = new RetiroDeEfectivo();
        this.consultaDeSaldo = new ConsultaDeSaldo();
    }

    public void retiroDeEfectivo() {
        System.out.print("Retiro de efectivo cliente Cobradores: ");
        retiroDeEfectivo.transaccionOk();
    }

    public void consultaDeSaldo() {
        System.out.print("Consulta de saldo cliente Cobradores: ");
        consultaDeSaldo.transaccionNoOk();
    }
}
