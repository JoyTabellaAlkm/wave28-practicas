package com.ejercicioblog.blog.repository;

import com.ejercicioblog.blog.entity.EntradaBlogEntity;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    private List<EntradaBlogEntity> entradas = new ArrayList<>(
            List.of(
                    new EntradaBlogEntity(1,"titanic", "Mauricio", LocalDate.of(2020,06,01)),
                    new EntradaBlogEntity(2,"titanic 1", "Juan", LocalDate.of(2020,05,01)),
                    new EntradaBlogEntity(3,"titanic 2", "Pedro", LocalDate.of(2021,04,12)),
                    new EntradaBlogEntity(4,"titanic 3", "Laura", LocalDate.of(2019,06,13)),
                    new EntradaBlogEntity(5,"titanic 4", "Gabriel", LocalDate.of(2024,06,01))
            )
    );


    @Override
    public EntradaBlogEntity filterById(int id) {
        Optional<EntradaBlogEntity> opcion = entradas.stream().filter(e -> e.getId() == id).findFirst();
        if (opcion.isPresent()){
            return opcion.get();
        }else{

        }
        return null;
    }

    @Override
    public EntradaBlogEntity agregarEntrada(EntradaBlogEntity entrada) {
        return null;
    }

    @Override
    public List<EntradaBlogEntity> listarTodas() {
        return entradas;
    }
}
