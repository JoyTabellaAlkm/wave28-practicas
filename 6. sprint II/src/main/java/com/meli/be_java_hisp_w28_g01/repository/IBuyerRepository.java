package com.meli.be_java_hisp_w28_g01.repository;

import com.meli.be_java_hisp_w28_g01.model.Buyer;

import java.util.List;

public interface IBuyerRepository {
    List<Buyer> getAll();
}
