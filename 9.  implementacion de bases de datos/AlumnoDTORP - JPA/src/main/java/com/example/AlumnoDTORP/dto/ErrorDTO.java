package com.example.AlumnoDTORP.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO {

    private String explanation;
    @JsonProperty("messages_list")
    private List<String> messagesList;

}