package com.mercadolibre.be_java_hisp_w28_g10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowRelationDTO {
    @JsonProperty("id_follower")
    private int idFollower; // ID del seguidor
    @JsonProperty("id_followed")
    private int idFollowed; // ID de la persona seguida
}