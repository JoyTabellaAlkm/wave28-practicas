package repository.impl;

import model.Customer;
import repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerImpl implements CrudRepository<Customer> {

    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        customers.add(customer);
        System.out.println("Cliente guardado correctamente");
    }

    @Override
    public Optional<Customer> findById(Integer dni) {
        return customers.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst();
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void show() {
        customers.forEach(System.out::println);
    }

    @Override
    public void deleteById(Integer dni) {
        Optional<Customer> customer = findById(dni);

        if (customer.isPresent()) {
            customers.remove(customer.get());
            System.out.printf("Se ha eliminado el cliente con DNI %s\n", dni);
        } else System.out.printf("No se ha encontrado el cliente con DNI %s\n", dni);
    }
}
