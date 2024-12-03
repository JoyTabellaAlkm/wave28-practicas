package Abstractas;

public class Serie2 extends Prototipo<Integer>{

    @Override
    public Integer calcularSiguiente() {
        setValor(getValor() + 2);
        return getValor();
    }

    @Override
    public void reiniciarValor() {
        setValor(null);
    }

    @Override
    public void establecerValorInicial(Integer valor) {
        setValor(valor);
    }
}
