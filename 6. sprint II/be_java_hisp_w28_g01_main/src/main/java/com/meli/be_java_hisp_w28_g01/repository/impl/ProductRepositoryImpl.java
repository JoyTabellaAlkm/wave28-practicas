package com.meli.be_java_hisp_w28_g01.repository.impl;

import com.meli.be_java_hisp_w28_g01.model.Product;
import com.meli.be_java_hisp_w28_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w28_g01.util.DataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class ProductRepositoryImpl implements IProductRepository {
    private final List<Product> listOfProduct;

    public ProductRepositoryImpl(DataLoader dataLoader, @Value("${product.file.path}") String filePath) {
        listOfProduct = dataLoader.loadDataBase(filePath, Product.class);
    }

    @Override
    public List<Product> getAll() {
        return listOfProduct;
    }

    @Override
    public Product add(Product product) {
        listOfProduct.add(product);
        return product;
    }
}
