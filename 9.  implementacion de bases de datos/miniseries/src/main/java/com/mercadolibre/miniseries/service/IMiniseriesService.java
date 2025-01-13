package com.mercadolibre.miniseries.service;

import com.mercadolibre.miniseries.dto.request.MiniSerieDTO;
import com.mercadolibre.miniseries.dto.response.MiniSerieDTOResponse;
import com.mercadolibre.miniseries.entity.MiniSerie;

import java.util.List;

public interface IMiniseriesService {
    public List<MiniSerie> getMiniSeries();
    public MiniSerieDTOResponse saveMiniSerie(MiniSerieDTO newMiniSerie);
    public void deleteMiniSerie(Long id);
    public MiniSerieDTOResponse findMiniserie(Long id);
}
