package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JewelryListResponse;
import com.bootcamp.LasPerlas.dto.JewelResponse;
import com.bootcamp.LasPerlas.model.Joya;

public interface IJoyaService {

    public JewelResponse saveJoya(Joya joya);
    public JewelryListResponse getJoyas();
    public Joya findJoya(Long id);
    public JewelResponse deleteJoya(Long id);
    public JewelResponse editJoya(Long id_modificar, Joya joya_modif);

}
