package com.mercadolibre.Blog.repository;

import com.mercadolibre.Blog.entity.EntradaBlogEntity;
import com.mercadolibre.Blog.exception.BlogDuplicateException;
import com.mercadolibre.Blog.exception.BlogNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private List<EntradaBlogEntity> listado = new ArrayList<>(List.of(
            new EntradaBlogEntity(1, "titanic", "Mauricio", LocalDate.of(2020, 06, 01)),
            new EntradaBlogEntity(2, "titanic", "Mauricio", LocalDate.of(2020, 06, 01)),
            new EntradaBlogEntity(3, "titanic2", "Mauricio", LocalDate.of(2020, 06, 01)),
            new EntradaBlogEntity(4, "titanic3", "Mauricio", LocalDate.of(2020, 06, 01)),
            new EntradaBlogEntity(5, "titanic4", "Mauricio", LocalDate.of(2020, 06, 01))
    ));


    @Override
    public EntradaBlogEntity filterById(int id) {
        Optional<EntradaBlogEntity> opcion = listado.stream().filter(x -> x.getId() == id).findFirst();
        if(opcion.isPresent()){
            return opcion.get();
        }else{
             throw new BlogNotFoundException("No se encontro el blog con el id: " + id);
        }
    }

    @Override
    public EntradaBlogEntity agregarEntrada(EntradaBlogEntity entrada) {
        try{
            EntradaBlogEntity filter = filterById(entrada.getId());

            if(filter != null){
                throw new BlogDuplicateException("Entrada duplicada con el id: " + filter.getId());
            }
        }catch (BlogNotFoundException e){
            listado.add(entrada);
        }


        return entrada;
    }

    @Override
    public List<EntradaBlogEntity> listarTodas() {
        return listado;
    }


}
