import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkroom {
    private final Map<Integer, List<Garment>> checkroomMap;
    private static Integer id;

    public Checkroom() {
        checkroomMap = new HashMap<>();
        id = 1;
    }

    public Integer storeGarments(List<Garment> garments){
        checkroomMap.put(id, garments);
        return id++;
    }

    public void showGarments(){
        for (Map.Entry<Integer, List<Garment>> checkroom: checkroomMap.entrySet()){
            System.out.printf("\nIdentificador asignado: %s .", checkroom.getKey());
            System.out.printf("Prendas guardadas: %s\n", checkroom.getValue());
        }
    }

    public List<Garment> returnGarments(Integer id){
        return checkroomMap.get(id);
    }

}
