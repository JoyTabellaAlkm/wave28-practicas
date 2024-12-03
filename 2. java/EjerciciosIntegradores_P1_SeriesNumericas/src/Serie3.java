import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serie3 extends Serie{

    public Serie3(){
        super();
        this.sumando = 3;
    }

    @Override
    void siguienteValor() {
        if(this.numerosSerie.isEmpty()){
            System.out.println("Debe seleccionar el valor inicial primero");
        }else{
            System.out.println("El siguiente número es: " + (this.numerosSerie.getLast()+sumando));
            this.numerosSerie.add(this.numerosSerie.getLast()+sumando);
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
