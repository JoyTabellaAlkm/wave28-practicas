package com.meli.be_java_hisp_w28_g01.repository.impl;

import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.repository.IBuyerRepository;
import com.meli.be_java_hisp_w28_g01.util.DataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class BuyerRepositoryImpl implements IBuyerRepository {
    private final List<Buyer> listOfBuyers;

    public BuyerRepositoryImpl(DataLoader dataLoader, @Value("${buyer.file.path}") String filePath) {
        listOfBuyers = dataLoader.loadDataBase(filePath, Buyer.class);
    }

    @Override
    public List<Buyer> getAll() {
        return listOfBuyers;
    }

}
