public class Serie3 extends Prototipo{

    public Serie3() {
        setValor(getValorInicial());
    }

    @Override
    void siguenteValor() {
        int nuevoValor = getValor() + 3;
        setValor(nuevoValor);
        System.out.println("Nuevo valor: " + nuevoValor);

    }
}
