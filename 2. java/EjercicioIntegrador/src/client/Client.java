package client;

import products.Locator;
import products.Product;

import java.util.List;

public class Client {
    String name;
    private final LocatorRepository locatorRepository;

    public Client(String name){
        this.name = name;
        this.locatorRepository = new LocatorRepository();
    }

    public LocatorRepository getRepository() {
        return locatorRepository;
    }

    public void buy(List<Product> productList){
        Locator locator = new Locator(productList, this);
        locatorRepository.add(locator);
    }


}
