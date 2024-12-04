public class Serie3 extends Prototipo{
    public Serie3() {
        super(0);
    }

    @Override
    public int valorSiguiente() {
        int val = getValor()+3;
        setValor(val);
        return val;
    }
}
