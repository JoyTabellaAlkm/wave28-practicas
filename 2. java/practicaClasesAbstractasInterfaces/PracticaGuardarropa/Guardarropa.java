package practicaClasesAbstractasInterfaces.PracticaGuardarropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {
    Map<Integer, List<Prenda>> mapaGuardarropa = new HashMap<>();

    Integer contador = 0;

    public Integer guardarPrenda (List<Prenda> listaPrenda){
        contador++;
        mapaGuardarropa.put(contador, listaPrenda);
        System.out.println("numero identificador: " + contador);
        return contador;
    }

    public void mostrarPrendas (){
        System.out.println("Todas las prendas guardadas");
        for(Map.Entry<Integer, List<Prenda>> entrada : mapaGuardarropa.entrySet() ){
            Integer clave = entrada.getKey();
            List<Prenda> valor = entrada.getValue();

            System.out.println("prendas guardadas con el identificador: " + clave);
            System.out.println(valor);
            System.out.println("---------------------------");
        }
        System.out.println("identificador: ");
    }
}
