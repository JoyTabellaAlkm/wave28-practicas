public class SerieMultiplicativa extends Prototipo<Integer> {
    private final int multiplicador; 

    public SerieMultiplicativa(Integer valorInicial, int multiplicador) {
        super(valorInicial);
        this.multiplicador = multiplicador;
    }

    @Override
    protected Integer valorSiguiente() {
        valorActual *= multiplicador; 
        return valorActual;
    }
}
