package banco;

public class Basic extends Cliente {
    public Basic(String nombreCliente) {
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
        return true;
    }

    @Override
    protected boolean puedeRetirarEfectivo() {
        return true;
    }
}
