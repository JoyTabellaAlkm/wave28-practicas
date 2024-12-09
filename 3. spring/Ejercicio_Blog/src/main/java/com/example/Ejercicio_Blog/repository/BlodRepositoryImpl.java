package com.example.Ejercicio_Blog.repository;

import com.example.Ejercicio_Blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlodRepositoryImpl implements IBlogRepository{

    private List<EntradaBlog> listaEntradas;

    public BlodRepositoryImpl(List<EntradaBlog> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    @Override
    public List<EntradaBlog> listAll() {
        return listaEntradas;
    }

    @Override
    public boolean create(EntradaBlog e) {
        return listaEntradas.add(e);
    }
    public int getAmountSize(){
        return listaEntradas.size();
    }


}
