package com.example.blog.repository;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.entity.EntradaBlog;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EntradaBlogReposiory {
    private List<EntradaBlog> entradaBloglist;

    private EntradaBlogReposiory(){
        entradaBloglist = getEntradas();
    }

    public List<EntradaBlog> getEntradas(){
        List<EntradaBlog> entradas = new ArrayList<>();
        try{
            File file = ResourceUtils.getFile("classpath:json/blog.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            entradas = mapper.readValue(file, new TypeReference<List<EntradaBlog>>(){});
        } catch(Exception e){
            System.out.println(e.getMessage());
            entradas = Collections.emptyList();
        }
        finally {
            System.out.println(entradas);
            return entradas;
        }
    }

    public List<EntradaBlog> getAllEntradas(){
        return entradaBloglist;
    }

    public EntradaBlog createEntrada(EntradaBlogDTO entrada){
        return new EntradaBlog(
                entrada.getId(),
                entrada.getTitle(),
                entrada.getAuthorName(),
                entrada.getPublicationDate()
        );
    }
}
