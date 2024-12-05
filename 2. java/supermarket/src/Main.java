import model.Customer;
import model.Invoice;
import model.Product;
import repository.impl.CustomerImpl;
import repository.impl.InvoiceImpl;
import repository.impl.ProductImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CustomerImpl customerService = new CustomerImpl();
        ProductImpl productService = new ProductImpl();
        InvoiceImpl invoiceService = new InvoiceImpl();

        Customer customer1 = new Customer(123456, "Santiago", "Montoya");
        Customer customer2 = new Customer(987654, "Sebastián", "Garzón");
        Customer customer3 = new Customer(457832, "Valentina", "Díaz");

        customerService.save(customer1);
        customerService.save(customer2);
        customerService.save(customer3);

        System.out.println("Listado inicial de clientes");
        customerService.show();

        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el DNI del cliente a borrar");
        Integer dni = sc.nextInt();

        customerService.deleteById(dni);

        System.out.println("\nListado de clientes después de eliminar");
        customerService.show();

        System.out.println("\nIngrese el DNI del cliente a buscar");
        dni = sc.nextInt();

        Optional<Customer> customerFound = customerService.findById(dni);

        if (customerFound.isPresent()) {
            System.out.printf("Se encontró el cliente con los siguientes datos: %s\n", customerFound.get());
        } else System.out.printf("No se encontró el cliente con DNI %s en la base de datos\n", dni);

        Customer customer4 = new Customer(345677, "Mauricio", "Pineda");

        Product milk = new Product("Leche", 2, 2500.0);
        Product sugar = new Product("Azúcar", 1, 1700.0);
        Product coffee = new Product("Café", 4, 8300.0);

        productService.save(milk);
        productService.save(sugar);
        productService.save(coffee);

        System.out.println("Listado de productos disponibles");
        productService.show();

        Invoice invoice = new Invoice(customer4, productService.findAll());

        invoiceService.save(invoice);
        System.out.printf("\nValor total de la factura: %.2f\n", invoice.getTotalCost());

        System.out.println("Listado de facturas generadas");
        invoiceService.show();

    }
}