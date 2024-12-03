package client;

import products.Locator;
import products.Package;
import products.Product;

import java.util.List;

public class Client {
    String name;
    private final LocatorRepository locatorRepository;
    double discount;

    public Client(String name){
        this.name = name;
        this.locatorRepository = new LocatorRepository();
        this.discount = 0;
    }

    public LocatorRepository getRepository() {
        return locatorRepository;
    }

    public void buy(Package aPackage){
        Locator locator = new Locator(aPackage.productList, this);
        locatorRepository.add(locator);
    }

    public double getFinalPrice(Package aPackage){
        aPackage.getFinalPrice();
//        Locator locator = new Locator(productList, this);
        int locatorsAmount = locatorRepository.getAmount();
        if(locatorsAmount >= 2) {
            discount = 0.05;
        }
        if(aPackage.isFullPackage()) {
           discount = 0.01;
        }
        if(productList.stream().anyMatch(Product::isPackage)) {
            discount = 0.05;
        }
    }


}