package com.meli.be_java_hisp_w28_g01.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({"id", "name", "followers"})
public class FollowersListDto {
    @JsonProperty("user_id")
    int id;
    @JsonProperty("user_name")
    String name;
    List<BuyerDto> followers;
}
