public class SerieDeUno extends Prototipo{
    public SerieDeUno(Integer valorInicial) {
        super(valorInicial);
    }

    @Override
    public Integer devolverSiguienteValor() {
        this.valorActual += 2;

        return this.valorActual;
    }


}
