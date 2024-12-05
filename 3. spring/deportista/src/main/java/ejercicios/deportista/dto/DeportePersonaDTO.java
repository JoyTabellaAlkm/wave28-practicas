package ejercicios.deportista.dto;

public class DeportePersonaDTO {
    private DeporteDTO deporte;
    private PersonaDTO persona;

    public DeportePersonaDTO() {
    }

    public DeportePersonaDTO(DeporteDTO deporte, PersonaDTO persona) {
        this.deporte = deporte;
        this.persona = persona;
    }

    public DeporteDTO getDeporte() {
        return deporte;
    }

    public void setDeporte(DeporteDTO deporte) {
        this.deporte = deporte;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
}
