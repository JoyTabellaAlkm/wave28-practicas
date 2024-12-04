package products;

import java.util.List;

public class Package extends Product {
    public List<Product> productList;

    public Package(Double price, List<Product> packageProductList){
        super(price);
        this.productList = packageProductList;
    }
}
