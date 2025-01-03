package com.mercadolibre.be_java_hisp_w28_g10.dto.follow;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponseUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("followers")
    private List<ResponseUserDTO> followers;
}
