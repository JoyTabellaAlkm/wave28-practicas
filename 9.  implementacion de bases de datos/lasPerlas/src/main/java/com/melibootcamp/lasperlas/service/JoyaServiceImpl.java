package com.melibootcamp.lasperlas.service;

import com.melibootcamp.lasperlas.entity.Joya;
import com.melibootcamp.lasperlas.repository.JoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {

    private final JoyaRepository joyaRepository;

    public JoyaServiceImpl (JoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getJoyas() {
        List<Joya> toReturn = joyaRepository.findAll();
        return toReturn;
    }

    @Override
    public boolean saveJoya(Joya joya) {
        try{
            joyaRepository.save(joya);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteJoya(long id) {
        try{
            joyaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Joya getJoyaById(long id) {
        Joya toReturn = joyaRepository.findById(id).orElse(null);
        return toReturn;
    }
}
