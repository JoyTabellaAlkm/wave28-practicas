package com.melibootcamp.obrasliterarias.service;

import com.melibootcamp.obrasliterarias.entity.ObraLiteraria;
import com.melibootcamp.obrasliterarias.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaServiceImpl implements ObraLiterariaService{

    @Autowired
    private ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public ObraLiteraria save(ObraLiteraria obra) {
        obra.setId(UUID.randomUUID().toString());
        return obraLiterariaRepository.save(obra);
    }

    @Override
    public List<ObraLiteraria> findAll() {
        List<ObraLiteraria> toReturn = StreamSupport.stream(obraLiterariaRepository.findAll().spliterator(), false).toList();
        return toReturn;
    }

    @Override
    public Optional<ObraLiteraria> findById(String id) {
        return obraLiterariaRepository.findById(id);
    }

    @Override
    public String delete(String id) {
        obraLiterariaRepository.deleteById(id);
        return "Eliminado con exito";
    }

    @Override
    public String update(ObraLiteraria obra, String id) {
        if(obraLiterariaRepository.existsById(id)){
            obra.setId(id);
            obraLiterariaRepository.save(obra);
            return "Articulo modificado con exito";
        }
        return "Id de obra no encontrada";
    }

    @Override
    public List<ObraLiteraria> findByAuthor(String autor) {
        return obraLiterariaRepository.findByAutor(autor);
    }

    @Override
    public List<ObraLiteraria> findByPatternInTitle(String pattern) {
        return obraLiterariaRepository.findByNombreContaining(pattern);
    }

    @Override
    public List<ObraLiteraria> findTop5BooksWithMostPagesAscOrder() {
        return obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();
    }

    @Override
    public List<ObraLiteraria> findBooksSoldPriorToSentYear(Integer year) {
        return obraLiterariaRepository.findByAnioPrimeraPublicacionIsLessThan(year);
    }

    @Override
    public List<ObraLiteraria> findByEditorial(String editorial) {
        return obraLiterariaRepository.findByEditorialEquals(editorial);
    }
}
