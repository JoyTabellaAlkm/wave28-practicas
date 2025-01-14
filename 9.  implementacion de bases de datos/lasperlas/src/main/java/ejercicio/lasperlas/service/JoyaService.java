package ejercicio.lasperlas.service;

import ejercicio.lasperlas.dto.JoyaDTO;
import ejercicio.lasperlas.model.Joya;
import ejercicio.lasperlas.dto.MessageDTO;
import ejercicio.lasperlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepository;


    @Override
    public MessageDTO saveJoya(Joya joya) {
        joyaRepository.save(joya);
        return new MessageDTO("La joya fue creada correctamente");
    }

    @Override
    public List<JoyaDTO> getJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    public MessageDTO deleteJoya(Long id) {
        return null;
    }

    @Override
    public JoyaDTO findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public MessageDTO upDate(Long id, Joya joyaModif) {
        return null;
    }
}
