public class SeriePorDecimal extends Prototipo<Double> {
    public SeriePorDecimal(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
        valorAcumulado = valorInicial;
    }

    @Override
    public Double siguienteValor() {
        return valorAcumulado += incremento;
    }
}
