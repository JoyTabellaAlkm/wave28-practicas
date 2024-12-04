public interface ICRUD <T>{
    void create(Long id, T s);
    T read(Long id);
    void update(Long id, T s);
    void delete(Long id);
}
