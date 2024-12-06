package com.example.demo.Model;

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
@Getter
public class Personaje {

    @JsonProperty("name")
    private String name;

    @JsonProperty("height")
    @JsonDeserialize(using = CustomIntDeserializer.class)
    private int height;

    @JsonProperty("mass")
    @JsonDeserialize(using = CustomIntDeserializer.class)
    private int mass;

    @JsonProperty("hairColor")
    private String hairColor;

    @JsonProperty("skinColor")
    private String skinColor;

    @JsonProperty("eyeColor")
    private String eyeColor;

    @JsonProperty("birthYear")
    private String birthYear;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("species")
    private String species;

    @Override
    public String toString() {
        return "Personaje{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", hairColor='" + hairColor + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
