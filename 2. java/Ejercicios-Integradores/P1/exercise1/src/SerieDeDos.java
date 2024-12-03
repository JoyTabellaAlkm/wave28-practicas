public class SerieDeDos extends Prototipo {
    public SerieDeDos(Integer valorInicial) {
        super(valorInicial);
    }

    @Override
    public Integer devolverSiguienteValor() {
        if(this.valorActual.equals(2)) {
            return this.valorActual;
        }
        this.valorActual += 2;
        return this.valorActual;
    }
}
