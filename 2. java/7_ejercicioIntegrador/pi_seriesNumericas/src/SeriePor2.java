public class SeriePor2  extends Prototipo<Integer>{

    public SeriePor2(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
        valorAcumulado = valorInicial;
    }

    @Override
    public Integer siguienteValor() {
        return valorAcumulado += incremento;
    }
}
