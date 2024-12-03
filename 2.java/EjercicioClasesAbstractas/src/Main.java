public class Main {
    public static void main(String[] args) {
        Serie doble = new DobleSerie(1);
        doble.next();
        doble.next();
        doble.next();
        doble.clear(10);
        doble.next();
        doble.clear();

        System.out.println("------------------------------");

        Serie triple = new TripleSerie(0);
        triple.next();
        triple.next();
        triple.next();
        triple.clear(10);
        triple.next();
        triple.clear();

    }
}

abstract class Serie {
    protected Integer inicial = 0;

    public Serie(Integer inicial) {
        this.inicial = inicial;
    }

    public abstract void next();

    public void clear(Integer inicial) {
        System.out.println("Limpiando seria con valor inicial: " + inicial);
        this.inicial = inicial;
    }

    public void clear() {
        System.out.println("Limpiando serie a cero");
        inicial = 0;
    }
}

class DobleSerie extends Serie {

    public DobleSerie(Integer inicial) {
        super(inicial);
    }

    @Override
    public void next() {
        System.out.println(inicial += 2);

    }
}

class TripleSerie extends Serie {

    public TripleSerie(Integer inicial) {
        super(inicial);
    }

    @Override
    public void next() {
        System.out.println(inicial += 3);

    }

}