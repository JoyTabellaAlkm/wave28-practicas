package com.meli.be_java_hisp_w28_g01.service;

import com.meli.be_java_hisp_w28_g01.dto.request.ProductDto;
import com.meli.be_java_hisp_w28_g01.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> getAll();
    public Optional<Product> findById(int id);
    public Product add(ProductDto productDto);
}
