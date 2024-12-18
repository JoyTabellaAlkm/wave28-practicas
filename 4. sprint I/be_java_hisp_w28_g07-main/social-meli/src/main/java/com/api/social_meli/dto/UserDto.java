package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String name;
    private List<Integer> followed;
    private List<Integer> followers;
    private List<Integer> posts;
}
