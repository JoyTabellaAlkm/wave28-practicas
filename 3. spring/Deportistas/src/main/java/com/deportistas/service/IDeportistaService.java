package com.deportistas.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IDeportistaService<T,K> {
    List<T> findAllSports();

    List<T> findByName(String name);

    List<K> findAllPersons();
}