import java.util.List;

public abstract class Repositorio<T>{
    private List<T> storage;
    public List<T> getAll(){
        return this.storage;
    }
    public abstract T buscarPorId(Integer id);
    public void add(T object){
        this.storage.add(object);
    }

}
