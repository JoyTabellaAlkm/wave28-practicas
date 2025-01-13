package com.bootcampMeli.miniSeries.service;

import com.bootcampMeli.miniSeries.repository.MiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final MiniSerieRepository miniSerieRepository;

    public MiniSerieService(MiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }
}
