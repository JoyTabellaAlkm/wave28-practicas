package banco;

public class Cobrador extends Cliente {
    public Cobrador(String nombreCliente) {
        super(nombreCliente);
    }

    @Override
    protected boolean puedeTransferir() {
        return false;
    }

    @Override
    protected boolean puedeDepositar() {
        return false;
    }

    @Override
    protected boolean puedeConsultarSaldo() {
        return true;
    }

    @Override
    protected boolean puedePagarServicios() {
        return false;
    }

    @Override
    protected boolean puedeRetirarEfectivo() {
        return true;
    }
}
