package com.mercadolibre.obraliteraria.repository;

import com.mercadolibre.obraliteraria.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    List<ObraLiteraria> findObraLiterariaByAutor(String autor);
    List<ObraLiteraria> findObraLiterariaByNombreContainingIgnoreCase(String keyword);
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiteraria> findObraLiterariaByPrimeraPublicacionBefore(int primeraPublicacionBefore);
    List<ObraLiteraria> findObraLiterariaByEditorial(String editorial);
}
