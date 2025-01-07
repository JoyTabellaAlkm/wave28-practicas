package com.bootcamp.socialmeli.dto.response;

import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.LongNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFollowedDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDto> followed;
}
