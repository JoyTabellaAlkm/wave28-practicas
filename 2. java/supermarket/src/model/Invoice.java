package model;

import java.util.List;

public class Invoice {
    private Integer id;
    private Customer customer;
    private List<Product> products;
    private final Double totalCost;

    public Invoice(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        totalCost = calculateTotalCost();
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
        return this.totalCost;
    }

    public Double calculateTotalCost() {
        return products.stream()
                .mapToDouble(product -> product.getQuantity() * product.getCost())
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
