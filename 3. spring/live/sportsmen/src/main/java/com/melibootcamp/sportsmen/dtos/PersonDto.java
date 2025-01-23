package com.melibootcamp.sportsmen.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    @JsonProperty("sports_list")
    @JsonIgnore
    private List<SportDto> sportsList;

}
