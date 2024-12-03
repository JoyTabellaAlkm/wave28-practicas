import java.util.ArrayList;
import java.util.List;

public abstract class Prototipo <T extends Number>{
    private T valorActual;
    private T valorAumento;

    public Prototipo() {
    }

    public abstract T getSiguienteValorSerie() throws IllegalAccessException;

    public abstract void reiniciarSerie();

    public abstract void setValorInicialSerie(T valor);

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public T getValorAumento() {
        return valorAumento;
    }

    public void setValorAumento(T valorAumento) {
        this.valorAumento = valorAumento;
    }
}
