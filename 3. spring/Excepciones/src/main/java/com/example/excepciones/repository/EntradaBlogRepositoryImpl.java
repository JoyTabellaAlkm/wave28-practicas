package com.example.excepciones.repository;

import com.example.excepciones.modelo.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository{

    List<EntradaBlog> listaBlogs = new ArrayList<>();

    @Override
    public Boolean crearEntrada(EntradaBlog entradaBlog) {

        return listaBlogs.add(entradaBlog);
    }

    @Override
    public EntradaBlog buscarPorId(Long id) {

        List<EntradaBlog> blogs = listaBlogs.stream()
                .filter( entradaBlog ->  entradaBlog.getId()
                        .equals(id)).toList();

        if(blogs.isEmpty()){
            return null;
        }

        return blogs.get(0);
    }

    @Override
    public List<EntradaBlog> obtenerBlogs() {
        return  listaBlogs;
    }
}
