import java.util.List;

public class Invoice {
    private Integer id;
    private Customer customer;
    private List<Product> products;

    public Invoice(Integer id, Customer customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalCost() {
        return products.stream()
                 .mapToDouble( product -> product.getQuantity() * product.getCost())
                 .sum();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                " id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
