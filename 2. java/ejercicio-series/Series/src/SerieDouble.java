public class SerieDouble extends Prototipo<Double>{
    public SerieDouble(Double valorInicial, Double saltoValor) {
        super(valorInicial, saltoValor);
    }

    @Override
    public Double obtenerSiguienteValor() {
       valorActual += saltoValor;
        return valorActual;
    }
}
