package client;

import products.Product;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    public Optional<T> get(T item);
    public List<T> add(T item);

}
