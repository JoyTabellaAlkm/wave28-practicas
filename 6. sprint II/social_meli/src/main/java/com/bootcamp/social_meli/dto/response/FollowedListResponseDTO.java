package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowedListResponseDTO extends SimpleUserResponseDTO {
    List<SimpleUserResponseDTO> followed;
}
