package com.mercadolibre.kartsrelaciones.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.kartsrelaciones.dto.KartDTO;
import com.mercadolibre.kartsrelaciones.dto.PilotDTO;
import com.mercadolibre.kartsrelaciones.dto.RaceDTO;
import com.mercadolibre.kartsrelaciones.entity.Country;
import com.mercadolibre.kartsrelaciones.entity.Kart;
import com.mercadolibre.kartsrelaciones.entity.Pilot;
import com.mercadolibre.kartsrelaciones.entity.Race;
import com.mercadolibre.kartsrelaciones.repository.IRaceRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RaceService implements IRaceService {

    private final IRaceRepository raceRepository;
    private final ObjectMapper objectMapper;

    public RaceService(IRaceRepository raceRepository, ObjectMapper objectMapper) {
        this.raceRepository = raceRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public Long createRace(RaceDTO raceCarga) {

        Race r = new Race();
        r.setNombre(raceCarga.getNombre());
        r.setFecha(raceCarga.getFecha());

        Country c = new Country();
        c.setNombre(raceCarga.getPais().getNombre());
        c.setCodigo(raceCarga.getPais().getCodigo());

         Set<Pilot> pilotos = new HashSet<>();
         for (PilotDTO p : raceCarga.getPilotos()) {
             Pilot piloto = new Pilot();
             piloto.setNombre(p.getNombre());
             piloto.setEdad(p.getEdad());

             Kart kart = new Kart();
                kart.setModelo(p.getKart().getModelo());
                kart.setVelocidadMaxima(p.getKart().getVelocidadMaxima());
                kart.setPiloto(piloto);

             piloto.setKart(kart);
             pilotos.add(piloto);
         }

        r.setPilotos(pilotos);
        r.setPais(c);

        raceRepository.save(r);
        return r.getId();
    }

    @Override
    public List<RaceDTO> getAllRaces() {
        return raceRepository.findAll().stream().map(v -> objectMapper.convertValue(v, RaceDTO.class)).toList();
    }
}
