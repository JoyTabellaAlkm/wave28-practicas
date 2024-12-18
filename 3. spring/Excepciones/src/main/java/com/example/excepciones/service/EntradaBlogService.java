package com.example.excepciones.service;

import com.example.excepciones.dto.EntradaBlogDTO;
import com.example.excepciones.exception.AlreadyExistsException;
import com.example.excepciones.exception.NotFoundException;
import com.example.excepciones.modelo.EntradaBlog;
import com.example.excepciones.repository.EntradaBlogRepositoryImpl;
import com.example.excepciones.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    @Autowired
    IEntradaBlogRepository entradaBlogRepository;

    @Override
    public Boolean crearEntradaBlog(EntradaBlogDTO entradaBlog) {

        ObjectMapper objectMapper = new ObjectMapper();

        EntradaBlog blogEntity =  objectMapper.convertValue(entradaBlog, EntradaBlog.class);
        EntradaBlog blog = entradaBlogRepository.buscarPorId(blogEntity.getId());


        if(blog != null){
            throw  new AlreadyExistsException("Ya existe una entrada con ese id");
        }

        return entradaBlogRepository.crearEntrada(blogEntity);
    }

    @Override
    public EntradaBlogDTO obtenerBlogPorId(Long id) {

        ObjectMapper objectMapper = new ObjectMapper();
        EntradaBlog blogEntity =  entradaBlogRepository.buscarPorId(id);

        EntradaBlogDTO entradaBlog =  objectMapper.convertValue(blogEntity, EntradaBlogDTO.class);

        if(entradaBlog == null){
            throw new NotFoundException("No se encontro un blog por ese id");
        }

        return entradaBlog;
    }

    @Override
    public List<EntradaBlogDTO> obtenerBlogs() {

        ObjectMapper objectMapper = new ObjectMapper();

        List<EntradaBlog> listaBlogEntities = entradaBlogRepository.obtenerBlogs();
        List<EntradaBlogDTO> listBlogDTO =  listaBlogEntities.stream()
                .map( blog -> objectMapper.convertValue(blog, EntradaBlogDTO.class))
                .toList();

        if(listaBlogEntities.isEmpty()){
            throw new NotFoundException("No se encontraron blogs");
        }

        return listBlogDTO;
    }
}
