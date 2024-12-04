package interfaces;

public interface ICrud <T, K>{
    public T create(T object) throws Exception;
    public T delete(K id) throws Exception;
    public T get(K id);
}
