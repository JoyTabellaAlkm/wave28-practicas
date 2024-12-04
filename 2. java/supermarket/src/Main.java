import java.util.*;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("123456", "Santiago", "Montoya");
        Customer customer2 = new Customer("987654", "Sebastián", "Garzón");
        Customer customer3 = new Customer("457832", "Valentina", "Díaz");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        System.out.println("Listado inicial de clientes");
        printCustomers(customers);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el DNI del cliente a borrar");
        String dni = sc.nextLine();

        boolean customerDeleted = customers.removeIf( customer -> customer.getDni().equals(dni));

        if (customerDeleted){
            System.out.printf("Se ha eliminado el cliente con DNI %s\n", dni);
        } else System.out.printf("No se ha encontrado el cliente con DNI %s\n", dni);

        System.out.println("\nListado de clientes después de eliminar");
        printCustomers(customers);

        System.out.println("\nIngrese el DNI del cliente a buscar");
        String dniFound = sc.nextLine();

        Customer customerFound = findCustomer(customers, dniFound);

        if (customerFound != null){
            System.out.printf("Se encontró el cliente con los siguientes datos: %s\n", customerFound);
        } else {
            System.out.printf("No se encontró el cliente con DNI %s en la lista\n", dniFound);
        }

        Customer customer4 = new Customer("345677", "Mauricio", "Pineda");

        Product milk = new Product("ABC123", "Leche", 2, 2500.0);
        Product sugar = new Product("ABC123", "Azúcar", 1, 1700.0);
        Product coffee = new Product("ABC123", "Café", 4, 8300.0);

        Invoice invoice = new Invoice(1, customer4, List.of(milk, sugar, coffee));

        if (findCustomer(customers, invoice.getCustomer().getDni()) == null){
            customers.add(customer4);
        }

        System.out.printf("\nFactura: %s", invoice);
        System.out.printf("\nValor total de la factura: %.2f\n", invoice.getTotalCost());

    }

    public static void printCustomers(List<Customer> customers){
        customers.forEach(System.out::println);
    }

    public static Customer findCustomer(List<Customer> customers, String dni){
        return customers.stream()
                .filter(customer -> customer.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }
}