package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"user_id", "user_name", "followers"})
public class UserFollowingSellerResponseDto {
    @JsonProperty("user_id")
    int id;

    @JsonProperty("user_name")
    String name;

    List<UserIdentificationDto> followers;
}