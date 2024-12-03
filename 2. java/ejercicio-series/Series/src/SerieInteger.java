public class SerieInteger extends Prototipo<Integer>{
    public SerieInteger(Integer valorInicial, Integer saltoValor) {
        super(valorInicial, saltoValor);
    }

    @Override
    public Integer obtenerSiguienteValor() {
        valorActual += saltoValor;
        return valorActual;
    }
}
