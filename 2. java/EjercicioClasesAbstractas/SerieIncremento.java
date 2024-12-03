public class SerieIncremento<T extends Number> extends Prototipo<T> {
    private int incremento;

    public SerieIncremento(T valorInicial, int incremento) {
        establecerValorInicial(valorInicial);
        this.incremento = incremento;
    }

    @Override
    public T siguiente() {
        valorActual = (T) Integer.valueOf(valorActual.intValue()+incremento);
        return valorActual;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }
    
}