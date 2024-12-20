package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserWithFollowersCountDTO extends SimpleUserDTO {
    private long followers_count;

    public SimpleUserWithFollowersCountDTO(Long user_id, String user_name, long followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }
}
