package com.spring1.meliSocial.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.spring1.meliSocial.dto.request.RequestPostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"user_id", "posts"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostIndexDto {
    @JsonProperty("user_id")
    private int userId;
    private List<ResponsePostDto> posts;
}
