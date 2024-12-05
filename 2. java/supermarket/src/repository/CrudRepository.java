package repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T t);

    Optional<T> findById(Integer id);

    List<T> findAll();

    void show();

    void deleteById(Integer id);
}
