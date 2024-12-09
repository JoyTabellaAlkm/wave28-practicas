package com.demo.demo.service;

import com.demo.demo.dto.EntradaBlogDTO;
import com.demo.demo.entity.EntradaBlog;
import com.demo.demo.exception.IDAlreadyExists;
import com.demo.demo.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class EntradaBlogService {

    @Autowired
    EntradaBlogRepository blogRepository;

    public int crearEntradaBlog(EntradaBlogDTO blogDTO) {
        if (blogRepository.alreadyExists(blogDTO.getId())) {
            throw new IDAlreadyExists("El blog con ID " + blogDTO.getId() + " ya existe!");
        }
        EntradaBlog blog = createEntityFromDTO(blogDTO);
        return blogRepository.save(blog);
    }

    private EntradaBlog createEntityFromDTO(EntradaBlogDTO blogDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(blogDTO.getFechaPublicacion(), formatter);
        return new EntradaBlog(
                blogDTO.getId(),
                blogDTO.getTitulo(),
                blogDTO.getNombre(),
                fecha
        );
    }
}
