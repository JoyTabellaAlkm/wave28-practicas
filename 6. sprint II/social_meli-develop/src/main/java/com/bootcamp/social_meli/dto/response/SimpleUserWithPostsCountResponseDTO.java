package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserWithPostsCountResponseDTO extends SimpleUserResponseDTO {
    private long posts_amount;

    public SimpleUserWithPostsCountResponseDTO(Long user_id, String user_name, long posts_amount) {
        super(user_id, user_name);
        this.posts_amount = posts_amount;
    }
}
