package com.deportistas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SportPersonDto {
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    String sport;
}
