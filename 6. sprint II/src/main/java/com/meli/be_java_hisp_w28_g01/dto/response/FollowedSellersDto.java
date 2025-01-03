package com.meli.be_java_hisp_w28_g01.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder({"id", "name", "followed"})
public class FollowedSellersDto {
    @JsonProperty("user_id")
    int id;
    @JsonProperty("user_name")
    String name;
    List<SellerDto> followed;
}

