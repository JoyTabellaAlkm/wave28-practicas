package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO extends SimpleUserDTO {
    private Integer count_followers;
    private Integer count_followed;
    private Integer count_post;
    private List<SimpleUserDTO> follower_not_followed;
    private List<SimpleUserDTO> followed_not_follower;

    public UserDetailsDTO(Long user_id, String user_name, Integer count_followers, Integer count_followed, Integer count_post, List<SimpleUserDTO> follower_not_followed, List<SimpleUserDTO> followed_not_follower) {
        super(user_id, user_name);
        this.count_followers = count_followers;
        this.count_followed = count_followed;
        this.count_post = count_post;
        this.follower_not_followed = follower_not_followed;
        this.followed_not_follower = followed_not_follower;
    }
}