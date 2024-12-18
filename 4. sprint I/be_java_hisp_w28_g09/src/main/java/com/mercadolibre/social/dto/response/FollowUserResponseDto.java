package com.mercadolibre.social.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowUserResponseDto {
    private Integer userId;
    private Integer userIdToFollow;
}
