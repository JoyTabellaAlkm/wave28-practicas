package repository.impl;

import model.Product;
import repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductImpl implements CrudRepository<Product> {

    private final List<Product> products = new ArrayList<>();
    private static Integer code = 1;

    @Override
    public void save(Product product) {
        product.setCode(code++);
        products.add(product);
        System.out.println("Producto guardado correctamente");
    }

    @Override
    public Optional<Product> findById(Integer code) {
        return products.stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void show() {
        products.forEach(System.out::println);
    }

    @Override
    public void deleteById(Integer code) {
        Optional<Product> product = findById(code);

        if (product.isPresent()) {
            products.remove(product.get());
            System.out.printf("Se ha eliminado el producto con código %s\n", code);
        } else System.out.printf("No se ha encontrado el producto con código %s\n", code);
    }
}
