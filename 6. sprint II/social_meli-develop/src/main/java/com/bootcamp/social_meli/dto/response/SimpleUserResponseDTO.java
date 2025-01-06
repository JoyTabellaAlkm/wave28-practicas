package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimpleUserResponseDTO {
    private Long user_id;
    private String user_name;
}
