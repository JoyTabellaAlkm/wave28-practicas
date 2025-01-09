package com.bootcamp.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {
    private int id;

    @JsonProperty("goal_name")
    private String name;

    @JsonProperty("target_followers")
    private int targetFollowers;

    @JsonFormat(pattern = "d-M-yyyy")
    private LocalDate deadline;
}
