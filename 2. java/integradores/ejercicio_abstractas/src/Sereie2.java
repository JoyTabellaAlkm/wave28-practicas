public class Sereie2 extends Prototipo{
    public Sereie2() {
        setValor(getValorInicial());
    }

    @Override
    void siguenteValor() {
        int nuevoValor = getValor() + 2;
        setValor(nuevoValor);
        System.out.println("Nuevo valor: " + nuevoValor);
    }
}
