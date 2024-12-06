package co.mercadolibre.deportistas.service.implement;

import co.mercadolibre.deportistas.dto.DeporteDTO;
import co.mercadolibre.deportistas.dto.PersonaDTO;
import co.mercadolibre.deportistas.service.IDeporteService;
import co.mercadolibre.deportistas.service.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportesService implements IDeporteService, IPersonaService {

    List<DeporteDTO> deportes;
    List<PersonaDTO> personas;
    public DeportesService(){
        deportes = new ArrayList<>();
        personas = new ArrayList<>();

        deportes.add(new DeporteDTO("Fútbol", "Profesional"));
        deportes.add(new DeporteDTO("Básquet", "Amateur"));

        personas.add(new PersonaDTO("Nico", "Albarracin", deportes.getFirst().getNombre()));
        personas.add(new PersonaDTO("Ana", "Caldas", deportes.getLast().getNombre()));
    }

    @Override
    public List<DeporteDTO> consultaDeportes() {
        return deportes;
    }

    @Override
    public DeporteDTO consultaPorNombre(String name) {
        Optional<DeporteDTO> deporte = deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst();

        if(deporte.isPresent()) return deporte.get();
        else throw new RuntimeException("Deporte no encontrado");
        //return deporte.orElseGet(() -> new DeporteDTO("Deporte no encontrado"));
    }

    @Override
    public List<PersonaDTO> listarPersonas() {
        return personas;
    }
}
