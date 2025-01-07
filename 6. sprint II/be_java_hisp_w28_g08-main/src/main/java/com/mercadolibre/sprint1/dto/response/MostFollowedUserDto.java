package com.mercadolibre.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint1.dto.util.MostFollowersPostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MostFollowedUserDto {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("number_of_followers")
    private Integer numberFollowers;

    private List<MostFollowersPostDto> posts;
}
