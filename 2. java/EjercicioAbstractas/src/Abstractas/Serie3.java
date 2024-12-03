package Abstractas;

public class Serie3 extends Prototipo<Integer>{

    @Override
    public Integer calcularSiguiente() {
        setValor(getValor() + 3);
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
