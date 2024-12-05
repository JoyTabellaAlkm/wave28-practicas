package products;

import client.Client;

import java.util.List;

public class Locator {

    public Locator(List<Product> productList, Client owner) {
        this.productList = productList;
    }

    public Client owner;
    List<Product> productList;
    double totalPrice;

}