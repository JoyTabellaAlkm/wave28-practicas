package Repositories.Interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository<T>{
    public Optional<List<T>> readAll();

    public Optional<T> readById(int id);

    public void create(T entity);

    public void update(T entity, int id);

    public void delete(int id);

}
