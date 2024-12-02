package banco;

public class Ejecutivo extends Cliente {
    public Ejecutivo(String nombreCliente) {
        super(nombreCliente);
    }

    @Override
    protected boolean puedeTransferir(){
        return true;
    }

    @Override
    protected boolean puedeDepositar() {
        return true;
    }

    @Override
    protected boolean puedeConsultarSaldo() {
        return false;
    }

    @Override
    protected boolean puedePagarServicios() {
        return false;
    }

    @Override
    protected boolean puedeRetirarEfectivo() {
        return false;
    }
}
