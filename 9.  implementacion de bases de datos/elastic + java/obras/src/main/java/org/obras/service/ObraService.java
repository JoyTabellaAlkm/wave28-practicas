package org.obras.service;

import org.obras.model.Obra;
import org.obras.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService implements iObraService {

    @Autowired
    private ObraRepository repo;

    @Override
    public List<Obra> findByAnio(String anio) { return repo.findByAnio(anio); }

    @Override
    public List<Obra> findByAutorContaining(String autor){ return repo.findByAutor(autor);}

    @Override
    public List<Obra> findTop5ByOrderByPaginasDesc() { return repo.findTop5ByOrderByPaginasDesc(); }
}
