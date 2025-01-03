package com.bootcamp.socialmeli.dto.response;

import com.bootcamp.socialmeli.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowUserDto {
    @JsonProperty("user_id")
    private Long id;
    @JsonProperty("user_name")
    private String name;
    private List<UserDto> followed;
}
