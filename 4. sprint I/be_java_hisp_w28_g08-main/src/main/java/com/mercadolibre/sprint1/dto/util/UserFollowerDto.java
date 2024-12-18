package com.mercadolibre.sprint1.dto.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerDto {
    /* Usuario seguido */
    private int userFollowed;

    /* Usuario seguidor */
    private int userFollower;
}
