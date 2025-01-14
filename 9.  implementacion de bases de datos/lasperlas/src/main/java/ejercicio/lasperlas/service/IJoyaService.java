package ejercicio.lasperlas.service;

import ejercicio.lasperlas.dto.JoyaDTO;
import ejercicio.lasperlas.model.Joya;
import ejercicio.lasperlas.dto.MessageDTO;

import java.util.List;

public interface IJoyaService {
    public MessageDTO saveJoya(Joya joya);
    public List<JoyaDTO> getJoyas();
    public MessageDTO deleteJoya(Long id);
    public JoyaDTO findJoya(Long id);
    public MessageDTO upDate(Long id, Joya joyaModif);
}
