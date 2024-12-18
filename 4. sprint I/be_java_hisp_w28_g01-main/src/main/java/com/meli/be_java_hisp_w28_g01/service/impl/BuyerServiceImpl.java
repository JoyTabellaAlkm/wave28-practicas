package com.meli.be_java_hisp_w28_g01.service.impl;

import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.repository.IBuyerRepository;
import com.meli.be_java_hisp_w28_g01.service.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements IBuyerService {

    @Autowired
    IBuyerRepository buyerRepository;

    @Override
    public List<Buyer> getAll() {
        return buyerRepository.getAll();
    }

    @Override
    public Optional<Buyer> findById(int id) {
        Optional<Buyer> buyer = buyerRepository.getAll()
                .stream()
                .filter(b->b.getId() == id)
                .findFirst();
        return buyer;
    }
}
