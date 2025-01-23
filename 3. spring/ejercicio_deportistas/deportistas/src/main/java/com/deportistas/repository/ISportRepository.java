package com.deportistas.repository;

import com.deportistas.model.Sport;

import java.util.List;

public interface ISportRepository {
    public List<Sport> findAll();
}
