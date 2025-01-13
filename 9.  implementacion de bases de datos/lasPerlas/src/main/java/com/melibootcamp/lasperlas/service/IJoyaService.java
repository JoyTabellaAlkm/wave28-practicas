package com.melibootcamp.lasperlas.service;

import com.melibootcamp.lasperlas.entity.Joya;

import java.util.List;

public interface IJoyaService {

    public List<Joya> getJoyas();
    public boolean saveJoya (Joya joya);
    public boolean deleteJoya (long id);
    public Joya getJoyaById(long id);

}
