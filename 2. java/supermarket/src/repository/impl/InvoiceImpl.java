package repository.impl;

import model.Invoice;
import repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceImpl implements CrudRepository<Invoice> {

    private final List<Invoice> invoices = new ArrayList<>();
    private final CustomerImpl customerService = new CustomerImpl();
    private static Integer id = 1;

    @Override
    public void save(Invoice invoice) {
        if (customerService.findById(invoice.getCustomer().getDni()).isEmpty()) {
            customerService.save(invoice.getCustomer());
        }
        invoice.setId(id++);
        invoices.add(invoice);
        System.out.println("Factura guardada correctamente");
    }

    @Override
    public Optional<Invoice> findById(Integer id) {
        return invoices.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Invoice> findAll() {
        return invoices;
    }

    @Override
    public void show() {
        invoices.forEach(System.out::println);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Invoice> invoice = findById(id);

        if (invoice.isPresent()) {
            invoices.remove(invoice.get());
            System.out.printf("Se ha eliminado la factura con ID %s\n", id);
        } else System.out.printf("No se ha encontrado la factura con ID %s\n", id);
    }

}
