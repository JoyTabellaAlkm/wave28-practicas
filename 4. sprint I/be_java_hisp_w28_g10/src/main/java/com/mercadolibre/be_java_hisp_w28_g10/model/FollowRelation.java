package com.mercadolibre.be_java_hisp_w28_g10.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowRelation {
    @JsonProperty("id_follower")
    private int idFollower; // ID del seguidor
    @JsonProperty("id_followed")
    private int idFollowed; // ID de la persona seguida
}



