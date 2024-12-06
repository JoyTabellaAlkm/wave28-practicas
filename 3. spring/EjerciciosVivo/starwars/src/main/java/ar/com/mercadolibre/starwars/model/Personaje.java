package ar.com.mercadolibre.starwars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Personaje {
    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private int height;
        private int mass;

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birthYear) {
        this.birth_year = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(String height) {
        if(height == "NA"){
            this.height = 0;
        }else{
            this.height = Integer.parseInt(height);
        }
    }

    public int getMass() {
        return mass;
    }

    public void setMass(String mass) {
        if(mass == "NA"){
            this.mass = 0;
        }else{
            this.mass = Integer.parseInt(mass);
        }
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "name='" + name + '\'' +
                ", hairColor='" + hair_color + '\'' +
                ", skinColor='" + skin_color + '\'' +
                ", eyeColor='" + eye_color + '\'' +
                ", birthYear='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                '}';
    }

    //ObjectMapper objectMapper = new ObjectMapper()
    //      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
}
