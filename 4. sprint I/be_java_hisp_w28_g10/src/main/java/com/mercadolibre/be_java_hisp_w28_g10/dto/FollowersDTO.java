package com.mercadolibre.be_java_hisp_w28_g10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowersDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("followers_count")
    private int followersCount;
}
