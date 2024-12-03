public class SerieCadaDos extends Prototipo<Integer>{

    public SerieCadaDos(int valorActual) {
        super(valorActual,2);
    }

    @Override
    public Integer valorSiguiente() {
        this.valorActual += valorIncremental;
        return valorActual;
    }


}
