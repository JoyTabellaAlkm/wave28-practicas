public class SerieCadaTres extends Prototipo<Integer>{

    public SerieCadaTres(int valorActual) {
        super(valorActual,3);
    }

    @Override
    public Integer valorSiguiente() {
        this.valorActual += valorIncremental;
        return valorActual;
    }
}
