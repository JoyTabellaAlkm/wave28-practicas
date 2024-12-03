package Repositories;

import Repositories.Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Repository<T> implements IRepository<T>{
    // ATTRIBUTE
    protected List<T> _data;

    public Repository(List<T> data) {
        _data = data;
    }

    @Override
    public abstract Optional<List<T>> readAll();

    @Override
    public abstract Optional<T> readById(int id);

    @Override
    public abstract void create(T entity);

    @Override
    public abstract void update(T entity, int id);

    @Override
    public abstract void delete(int id);
}
