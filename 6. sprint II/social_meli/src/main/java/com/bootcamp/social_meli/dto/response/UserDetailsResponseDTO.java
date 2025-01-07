package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponseDTO extends SimpleUserResponseDTO {
    private Integer count_followers;
    private Integer count_followed;
    private Integer count_post;
    private List<SimpleUserResponseDTO> follower_not_followed;
    private List<SimpleUserResponseDTO> followed_not_follower;

    public UserDetailsResponseDTO(Long user_id, String user_name, Integer count_followers, Integer count_followed, Integer count_post, List<SimpleUserResponseDTO> follower_not_followed, List<SimpleUserResponseDTO> followed_not_follower) {
        super(user_id, user_name);
        this.count_followers = count_followers;
        this.count_followed = count_followed;
        this.count_post = count_post;
        this.follower_not_followed = follower_not_followed;
        this.followed_not_follower = followed_not_follower;
    }
}