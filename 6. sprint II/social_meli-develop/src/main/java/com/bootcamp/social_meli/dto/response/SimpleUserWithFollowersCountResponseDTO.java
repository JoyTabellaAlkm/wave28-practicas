package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SimpleUserWithFollowersCountResponseDTO extends SimpleUserResponseDTO {
    private long followers_count;

    public SimpleUserWithFollowersCountResponseDTO(Long user_id, String user_name, long followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }
}
