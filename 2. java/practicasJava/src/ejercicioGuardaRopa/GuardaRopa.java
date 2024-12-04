package ejercicioGuardaRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    HashMap<Integer,List<Prenda>> prendasMap = new HashMap();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        prendasMap.put(prendasMap.size()+1, listaDePrenda);
        return prendasMap.size();
    }

    public void mostrarPrendas(){
        for (Integer codigoPrendas : prendasMap.keySet()){
            System.out.println(prendasMap.get(codigoPrendas));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendasMap.get(numero);
    }
}
