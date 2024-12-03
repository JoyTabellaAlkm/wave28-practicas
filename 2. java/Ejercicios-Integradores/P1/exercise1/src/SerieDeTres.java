public class SerieDeTres extends Prototipo{
    public SerieDeTres(Integer valorInicial) {
        super(valorInicial);
        this.valorActual = valorInicial;
    }

    @Override
    public Integer devolverSiguienteValor() {
        if(this.valorActual.equals(3)) {
            return this.valorActual;
        }
        this.valorActual += 3;
        return this.valorActual;
    }
}
