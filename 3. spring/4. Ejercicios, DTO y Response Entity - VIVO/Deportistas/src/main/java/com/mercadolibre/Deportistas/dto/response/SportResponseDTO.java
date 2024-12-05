package com.mercadolibre.Deportistas.dto.response;


public class SportResponseDTO {

    private String name;
    private String lastName;
    private String sport;

    public SportResponseDTO(String name, String lastName, String sport) {
        this.name = name;
        this.lastName = lastName;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
