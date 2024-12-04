public class SerieIncremental extends Prototipo<Integer> {
    private final int incremento;

    public SerieIncremental(Integer valorInicial, int incremento) {
        super(valorInicial);
        this.incremento = incremento;
    }

    @Override
    protected Integer valorSiguiente() {
        valorActual += incremento;
        return valorActual;
    }
}
