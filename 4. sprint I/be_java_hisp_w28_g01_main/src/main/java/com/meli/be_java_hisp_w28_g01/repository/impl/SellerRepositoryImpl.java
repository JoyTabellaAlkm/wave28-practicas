package com.meli.be_java_hisp_w28_g01.repository.impl;

import com.meli.be_java_hisp_w28_g01.model.Seller;
import com.meli.be_java_hisp_w28_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w28_g01.util.DataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerRepositoryImpl implements ISellerRepository {
    private final List<Seller> sellers;

    public SellerRepositoryImpl(DataLoader dataLoader, @Value("${seller.file.path}") String filePath) {
        sellers = dataLoader.loadDataBase(filePath, Seller.class);
    }

    @Override
    public List<Seller> getAll() {
        return sellers;
    }
}
