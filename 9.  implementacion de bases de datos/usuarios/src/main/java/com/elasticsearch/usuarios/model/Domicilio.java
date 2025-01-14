package com.elasticsearch.usuarios.model;

import lombok.Data;

@Data
public class Domicilio {
    String ciudad;
    String provincia;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
