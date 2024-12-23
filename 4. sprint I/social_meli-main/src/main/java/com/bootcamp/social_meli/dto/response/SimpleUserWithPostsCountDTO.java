package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserWithPostsCountDTO extends SimpleUserDTO {
    private long posts_amount;

    public SimpleUserWithPostsCountDTO(Long user_id, String user_name, long posts_amount) {
        super(user_id, user_name);
        this.posts_amount = posts_amount;
    }
}
