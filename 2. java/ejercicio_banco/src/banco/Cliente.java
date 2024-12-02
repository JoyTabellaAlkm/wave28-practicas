package banco;


public abstract class Cliente {
    private final String nombre;

    public Cliente(String nombreCliente) {
        nombre = nombreCliente;
    }

    public String getNombre() {
        return nombre;
    }

    protected abstract boolean puedeTransferir();

    protected abstract boolean puedeDepositar();

    protected abstract boolean puedeConsultarSaldo();

    protected abstract boolean puedePagarServicios();

    protected abstract boolean puedeRetirarEfectivo();

    public void realizarTransferencia(Cliente destino, Double monto) {
        new Transferencia(this, destino, monto);
    }

    public void realizarDeposito(Cliente destino, Double monto) {
        new Deposito(this, destino, monto);
    }

    public void consultarSaldo() {
        new ConsultaSaldo(this);
    }

    public void pagarServicios() {
        new PagarServicio(this);
    }

    public void retirarEfectivo() {
        new RetiroEfectivo(this);
    }
}
