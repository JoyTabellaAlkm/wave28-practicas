package com.melibootcamp.showroom.service;



import com.melibootcamp.showroom.entity.Prenda;
import com.melibootcamp.showroom.repository.PrendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements PrendaService {

    private final PrendaRepository prendaRepository;

    public PrendaServiceImpl(PrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<Prenda> getPrendas() {
        List<Prenda> toReturn = prendaRepository.findAll();
        return toReturn;
    }

    @Override
    public Prenda getPrendaById(long id) {
        Prenda toReturn = prendaRepository.findById(id).orElse(null);
        return toReturn;
    }

    @Override
    public List<Prenda> getPrendaBySize(String talle) {
        List<Prenda> toReturn = prendaRepository.findByTalle(talle);
        return toReturn;
    }

    @Override
    public List<Prenda> getPrendaByPatternOnTitle(String pattern) {
        List<Prenda> toReturn = prendaRepository.findByPatternOnTitle(pattern);
        return toReturn;
    }


    @Override
    public boolean savePrenda(Prenda Prenda) {
        try{
            prendaRepository.save(Prenda);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deletePrenda(long id) {
        try{
            prendaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    @Override
    public boolean updatePrenda(long id, Prenda prenda) {

        if (!prendaRepository.existsById(id)){
            return false;
        }

        prenda.setId(id);

        prendaRepository.save(prenda);
        return true;
    }


}
