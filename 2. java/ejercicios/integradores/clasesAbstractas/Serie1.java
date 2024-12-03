package ejercicios.integradores.clasesAbstractas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Serie1 extends Prototipo{
    private List<Integer> lista;

    public Serie1() {
        this.lista = new ArrayList<>();
    }

    @Override
    public int siguiente() {
        try {
            int res = lista.getLast() + 1;
            lista.add(res);
            return res;
        }
        catch (NoSuchElementException e){
            lista.add(0);
            return 0;
        }
    }

    @Override
    public void reinicio() {
        lista.clear();
    }

    @Override
    public void establecerInicio(int i) {
        lista.add(i);
    }

    @Override
    public String toString() {
        return "Serie1{" +
                "lista=" + lista +
                '}';
    }
}
