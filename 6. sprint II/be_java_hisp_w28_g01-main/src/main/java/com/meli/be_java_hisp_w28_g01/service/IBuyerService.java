package com.meli.be_java_hisp_w28_g01.service;

import com.meli.be_java_hisp_w28_g01.model.Buyer;

import java.util.List;
import java.util.Optional;

public interface IBuyerService {
    List<Buyer> getAll();
    Optional<Buyer> findById(int id);
}