package ejercicios.deportista.models;

import ejercicios.deportista.dto.DeporteDTO;
import ejercicios.deportista.dto.DeportePersonaDTO;
import ejercicios.deportista.dto.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

public class DeportePersonaModel {
    private static List<DeportePersonaDTO> deportePersona;

    static {
        deportePersona = new ArrayList<DeportePersonaDTO>();
        List<DeporteDTO> listaDeportes = DeportesModel.getListaDeportes();
        List<PersonaDTO> listaPersonas = PersonasModel.getListaPersonas();

        for (DeporteDTO deporte : listaDeportes) {
            for (PersonaDTO persona : listaPersonas) {
                deportePersona.add(new DeportePersonaDTO(deporte, persona)); // Crear la relación
            }
        }
    }

    public static List<DeportePersonaDTO> getDeportePersona() {
        return deportePersona;
    }
}
