package com.meli.be_java_hisp_w28_g01.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowersDto {
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("followers_count")
    int followersCount;
}
