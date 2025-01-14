package com.example.api_joyas.service;

import com.example.api_joyas.model.Joya;

import java.util.List;

public interface JoyaService {
    public Long createJoya(Joya joya);
    public Joya findJoya(Long id);
    public List<Joya> getJoyas();
    public Long deleteJoya(Long id);
    public Long updateJoya(Long id, Joya joya);
}
