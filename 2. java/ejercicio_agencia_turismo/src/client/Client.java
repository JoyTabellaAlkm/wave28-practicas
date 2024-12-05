package client;

import products.Locator;
import products.Package;
import products.Product;

import java.util.List;

public class Client {
    String name;
    private final LocatorRepository locatorRepository;

    public Client(String name) {
        this.name = name;
        this.locatorRepository = new LocatorRepository();
    }

    public boolean hasMoreThanOneLocator() {
        return locatorRepository.getAmount() >= 2;
    }

    public void buy(Package aPackage) {
        Locator locator = new Locator(aPackage.productList, this);
        locatorRepository.add(locator);
    }

    public double getFinalPriceFor(Package aPackage) {
        return aPackage.getPriceForClient(this);
    }
}