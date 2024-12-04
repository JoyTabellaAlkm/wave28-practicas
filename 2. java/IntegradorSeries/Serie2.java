public class Serie2 extends Prototipo{

    public Serie2() {
        super(0);
    }

    @Override
    public int valorSiguiente() {
        int val = getValor()+2;
        setValor(val);
        return val;
    }
}
