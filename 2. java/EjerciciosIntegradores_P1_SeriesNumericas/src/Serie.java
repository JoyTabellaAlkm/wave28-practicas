import java.util.ArrayList;
import java.util.List;

public abstract class Serie {
    List<Integer> numerosSerie;
    Integer sumando;

    public Serie(){
        this.numerosSerie = new ArrayList<>();
    }

    abstract void siguienteValor();
    abstract void reiniciarSerie();
    abstract void establecerValorInicial(Integer inicial);
    public void imprimir(){
        System.out.println(this.numerosSerie);
    }


}
