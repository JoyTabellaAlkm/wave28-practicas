package com.bootcamp.link_tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackDTO {
    private Long id;
    private String url;
    private String link_url;
    private Long times_called;
    @JsonProperty("is_active")
    private boolean is_active;
}
