package co.mercadolibre.deportistas.service;

import co.mercadolibre.deportistas.dto.DeporteDTO;

import java.util.List;

public interface IDeporteService {
    List<DeporteDTO> consultaDeportes();
    DeporteDTO consultaPorNombre(String name);
}
