import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serie2 extends Serie{

    public Serie2(){
        super();
        this.sumando = 2;

    }

    @Override
    void siguienteValor() {
        if(this.numerosSerie.isEmpty()){
            System.out.println("Debe seleccionar el valor inicial primero");
        }else{
            Integer prox = this.numerosSerie.getLast()+sumando;
            System.out.println("El siguiente número es: " + prox);
            numerosSerie.add(prox);
        }
    }

    @Override
    void reiniciarSerie() {
        if(this.numerosSerie.isEmpty()){
            System.out.println("La serie no se puede reiniciar porque esta vacia");
        }else {
            Integer inicial = this.numerosSerie.getFirst();
            this.numerosSerie = List.of(inicial);
        }
    }

    @Override
    void establecerValorInicial(Integer inicial) {
        this.numerosSerie = new ArrayList<Integer>(Arrays.asList(inicial));
    }
}
