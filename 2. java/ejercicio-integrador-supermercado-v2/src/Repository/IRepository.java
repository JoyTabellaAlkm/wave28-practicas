package Repository;
import java.util.List;

public interface IRepository<T> {

    public List<T> getAll();

    public T getOne(String id);

    public void create(T obj);

    public void delete(String id);

}
