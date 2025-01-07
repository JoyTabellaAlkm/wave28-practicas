package com.mercadolibre.sprint1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollower {

	/* Usuario seguido */
	private int userFollowed;

	/* Usuario seguidor */
	private int userFollower;

}
