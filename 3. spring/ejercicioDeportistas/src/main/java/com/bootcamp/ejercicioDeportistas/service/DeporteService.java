package com.bootcamp.ejercicioDeportistas.service;

import com.bootcamp.ejercicioDeportistas.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteService implements IDeporteService {
    List<Deporte> deportes;
    public DeporteService() {
        // Inicializar con algunos deportes
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol", "Profesional"));
        deportes.add(new Deporte("Tenis de mesa", "Amateur"));
        deportes.add(new Deporte("Tenis", "Amateur"));
    }

    public String getDeportes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Deportes:\n");

        for (Deporte deporte : deportes) {
            sb.append(deporte.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public Optional<String> getDeportesByName(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .map(Deporte::getNivel)
                .findFirst();
    }
}
