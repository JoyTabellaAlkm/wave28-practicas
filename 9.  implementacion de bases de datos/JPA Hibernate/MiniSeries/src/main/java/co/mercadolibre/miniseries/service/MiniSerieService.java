package co.mercadolibre.miniseries.service;

import co.mercadolibre.miniseries.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {

    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository IMiniSerieRepository) {
        this.miniSerieRepository = IMiniSerieRepository;
    }
}
