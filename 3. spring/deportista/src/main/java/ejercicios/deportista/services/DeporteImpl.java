package ejercicios.deportista.services;

import ejercicios.deportista.dto.DeporteDTO;

import java.util.ArrayList;
import java.util.List;

public class DeporteImpl implements IDeporte{
    List<DeporteDTO> DeporteDtolist = new ArrayList<DeporteDTO>();


    @Override
    public List<DeporteDTO> encontrarDeportes(){
    return DeporteDtolist;
    }
}
